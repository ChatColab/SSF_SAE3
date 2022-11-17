package fr.g13;

import java.sql.*;

public class SQLManager {

    private final String username;
    private final String password;
    private Connection con;

    public SQLManager(){
        this("root", "root");
    }

    public SQLManager(String username, String password){
        this.username = (username == null) ? "root" : username;
        this.password = (username == null) ? "root" : password;
    }

    /**
     * Permet de se connecter à la base de données
     *
     * @return True ou false selon si la connection a réussi
     */
    public boolean createConnection(){
        // Première étape
        String nomDriverJdbcDuSGBD = "com.mysql.cj.jdbc.Driver";

        // Deuxième étape
        String urlBD = "jdbc:mysql://localhost:3306/sae3";
        try {
            Class.forName(nomDriverJdbcDuSGBD);
            System.out.println("Le chargement du Driver JDBC mysql c'est déroulé avec succès");

            try {
                con = DriverManager.getConnection(urlBD, username, password);
                System.out.println("La connection à la base de données a réussi");
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Permet d'obtenir le nom d'un utilisateur en fonction de son id
     *
     * @param id
     *      L'id de l'utilisateur
     * @return Le nom de l'utilisateur (Ou null s'il n'est pas trouvé)
     */
    public String getUserNameById(int id){
        String name = null;

        try {
            String sqlRequest = "SELECT nom_utilisateur FROM utilisateurs WHERE id_utilisateur = " + id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlRequest);
            if(rs.next()){
                name = rs.getString("nom_utilisateur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }

    /**
     * Permet d'obtenir toutes les informations d'un utilisateur en fonction de son id
     *
     * @param id
     *      L'id de l'utilisateur
     * @return Toutes les informations d'un utilisateur (Ou null s'il n'est pas trouvé)
     */
    public String[] getUserById(int id){
        String[] infoUtilisateur = null;

        try {
            String sqlRequest = "SELECT * FROM utilisateurs WHERE id_utilisateur = " + id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlRequest);
            if(rs.next()){
                infoUtilisateur = new String[6];
                infoUtilisateur[0] = rs.getString("prenom_utilisateur");
                infoUtilisateur[1] = rs.getString("nom_utilisateur");
                infoUtilisateur[2] = rs.getString("heure_par_jour_utilisateur");
                infoUtilisateur[3] = rs.getString("id_groupe");
                infoUtilisateur[4] = rs.getString("id_role");
                infoUtilisateur[5] = rs.getString("id_etablissement");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return infoUtilisateur;
    }
}
