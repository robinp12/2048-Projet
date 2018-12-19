# 2048-Projet

VueGUI2048.java
//Commentaires
J'ai pris énormément de temps a comprendre comment fonctionnaient le frame et ses composants, l'affichage buguait et affichait le dernier element en plein écran automatiquement.
Après avoir résolu ce problème grace au .setLayout(null) qui fait que l'on peut placer les éléments brut grace aux pixels sans que la position soit générée automatiquement, tout a commencé à être plus facile et j'ai su avancer comme je le voulais.
J'ai voulu ajouter les boutons "flèches" sur la fenêtre pour pouvoir cliquer dessus au lieu d'utiliser le clavier physique, on peut donc jouer avec le clavier aussi bien qu'avec les boutons.
On a d'abord essayé de trouver une formule pour generer les tuiles en fonction de la valeur entrée par l'utilisateur (ex: 4x4) mais trop compliquée, on a décidé d'utiliser un switch-case pour chacune des valeurs.
Le score, le temps et la couleur du titre qui change au lancement sont synchronisés sur le timer.
Notre 2048 va jusqu'à 128 car le jeu allant jusqu'à 2048 est trop long à jouer et donc pas possible de montrer toutes fonctions durant la présentation orale.
Par défaut les cases sont en 4x4, mais dès le début, une fenêtre pop-up s'ouvre et vous pouvez choisir de 2x2 à 9x9, vous ne pouvez plus changer en cours de jeu.
