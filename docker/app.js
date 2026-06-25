
const zxcvbn = require("zxcvbn");

// mot de passe reçu depuis Java
const password = process.argv[2];

// analyse
const result = zxcvbn(password);

// conversion du score (0 à 4)
let scoreText = "";

switch (result.score) {
    case 0:
        scoreText = "Très faible";
        break;
    case 1:
        scoreText = "Faible";
        break;
    case 2:
        scoreText = "Moyen";
        break;
    case 3:
        scoreText = "Fort";
        break;
    case 4:
        scoreText = "Très fort";
        break;
}

console.log(scoreText);