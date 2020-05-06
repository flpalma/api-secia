package br.com.secia.apisecia.utils;

public class JdbcUtils {

    public static final String USUARIO_POR_LOGIN = "SELECT login, senha, ativo, nome FROM tb_user"
            + " WHERE login = ?";

    public static final String PERMISSOES_POR_USUARIO = "SELECT u.login, p.nome as nome_permissao FROM tb_user_permission up"
            + " JOIN tb_user u ON u.codigo = up.codigo_tb_user"
            + " JOIN tb_permission p ON p.codigo = up.codigo_tb_permission"
            + " WHERE u.login = ?";

    public static final String PERMISSOES_POR_GRUPO = "SELECT g.codigo, g.nome, p.nome  as nome_permissao FROM tb_group_permission gp"
            + " JOIN tb_group g ON g.codigo = gp.codigo_tb_group"
            + " JOIN tb_permission p ON p.codigo = gp.codigo_tb_permission"
            + " JOIN tb_user_group ug ON ug.codigo_tb_group = g.codigo"
            + " JOIN tb_user u ON u.codigo = ug.codigo_tb_user"
            + " WHERE u.login = ?";
}
