package br.com.secia.apisecia.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import static br.com.secia.apisecia.utils.JdbcUtils.*;

import br.com.secia.apisecia.model.User;
import br.com.secia.apisecia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SeciaUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(SeciaUserDetailsService.class.getSimpleName());

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            SeciaUserDetails userDetails = buscarUsuario(connection, login);

            Collection<GrantedAuthority> permissoesPorUsuario = buscarPermissoes(connection,
                    login, PERMISSOES_POR_USUARIO);

            Collection<GrantedAuthority> permissoesPorGrupo = buscarPermissoes(connection,
                    login, PERMISSOES_POR_GRUPO);

            userDetails.getAuthorities().addAll(permissoesPorUsuario);
            userDetails.getAuthorities().addAll(permissoesPorGrupo);

            return userDetails;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Problemas com a tentativa de conexão!", e);
            throw new UsernameNotFoundException("Problemas com a tentativa de conexão!", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Problemas ao tentar fechar a conexão!", e);
                throw new UsernameNotFoundException("Problemas ao tentar fechar a conexão!", e);
            }
        }
    }

    public SeciaUserDetails buscarUsuario(Connection connection, String login) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(USUARIO_POR_LOGIN);
        ps.setString(1, login);

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            throw new UsernameNotFoundException("Usuário " + login + " não encontrado!");
        }

        String nome = rs.getString("nome");
        String password = rs.getString("senha");
        boolean ativo = rs.getBoolean("ativo");

        rs.close();
        ps.close();

        return new SeciaUserDetails(nome, login, password, ativo);
    }

    public Collection<GrantedAuthority> buscarPermissoes(Connection connection, String login, String sql) throws SQLException {
        List<GrantedAuthority> permissoes = new ArrayList<>();

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, login);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            permissoes.add(new SimpleGrantedAuthority(rs.getString("nome_permissao")));
        }

        rs.close();
        ps.close();

        return permissoes;
    }

    public User buscarUsuarioPorEmail(String email) {
        return repository.findByLogin(email);
    }
}
