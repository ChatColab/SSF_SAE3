package fr.g13;

public class Main {

    public static void main(String[] args) {
        SQLManager sqlManager = new SQLManager("root", "root");
        boolean connectionReussi = sqlManager.createConnection();

        System.out.println("----------------------------");

        if(connectionReussi){

            String nomUtilisateur = sqlManager.getUserNameById(1);
            if(nomUtilisateur != null)
                System.out.println(nomUtilisateur);
            else System.out.println("L'utilisateur n'a pas été trouvé");

            System.out.println("----------------------------");

            String[] utilisateurInfo = sqlManager.getUserById(45);
            if(utilisateurInfo != null){
                System.out.println("Prénom : " + utilisateurInfo[0]);
                System.out.println("Nom : " + utilisateurInfo[1]);
                System.out.println("Nombre d'heure par jour : " + utilisateurInfo[2]);
                System.out.println("Id du groupe : " + utilisateurInfo[3]);
                System.out.println("Id du role : " + utilisateurInfo[4]);
                System.out.println("Id de l'établissement : " + utilisateurInfo[5]);
            } else System.out.println("L'utilisateur n'a pas été trouvé");
        }
    }
}
