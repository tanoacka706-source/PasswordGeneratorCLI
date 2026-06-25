PasswordGeneratorCLI

Application CLI développée en Java 21 permettant de générer des mots de passe sécurisés et d’évaluer leur robustesse via un conteneur Docker.
 1. Prérequis
Avant d’exécuter le projet, assurez-vous d’avoir installé : Java 21, Docker Desktop, Maven (optionnel selon exécution)

2. Fonctionnalités
Génération de mots de passe
L’utilisateur peut personnaliser : la longueur du mot de passe
les types de caractères : minuscules, majuscules, chiffres, symboles
Mode rafale
Le programme peut générer plusieurs mots de passe en une seule exécution.
Analyse de robustesse
Chaque mot de passe est évalué selon un niveau de sécurité : Très faible, Faible, Moyen, Fort, Très fort
L’analyse est réalisée via un conteneur Docker. Interface CLI. L’application fonctionne uniquement via le terminal à l’aide d’arguments.

3. Architecture du projet
Java Application → Docker Container → Analyse de sécurité → Résultat

5. Technologies utilisées
Java 21
Docker

6. Docker
Construction de l’image: cd docker
docker build -t password-analyzer .
Exécution du conteneur
docker run password-analyzer "Abc12345!"
7. Lancement du projet Java (Compilation / exécution)
java -cp target/classes ci.univmetiers.passwordgenerator.Main 12 true true true true 3
Format des paramètres
<length> <lower> <upper> <digits> <symbols> <count>. Exemple: 12 true true true true 3 : Génère 3 mots de passe sécurisés.

8. Exemples de sortie
. A9k#Lm2P → Fort
. Zx8@LpQ7 → Moyen
. Wp2!KsT9 → Très fort

9. Communication Java ↔ Docker
Java utilise ProcessBuilder pour appeler Docker :
ProcessBuilder pb = new ProcessBuilder(
    "docker", "run", "--rm",
    "password-analyzer",
    password
);
Le résultat est récupéré via BufferedReader.
10. Structure du projet
PasswordGeneratorCLI/
 ├── docker/
 │    ├── Dockerfile
 │    └── app.js
 ├── src/
 │    └── main/java/ci/univmetiers/passwordgenerator/
 │         ├── Main.java
 │         └── PasswordGenerator.java
 ├── pom.xml
 ├── README.md

11. Commandes utilisées
Build Docker
docker build -t password-analyzer .
Run Docker
docker run password-analyzer "Abc12345!"
Exécution Java
java -cp target/classes ci.univmetiers.passwordgenerator.Main 12 true true true true 3

13. Objectif du projet
Ce projet illustre une architecture DevOps simple : génération de mots de passe en Java, analyse externe via Docker, communication inter-processus
