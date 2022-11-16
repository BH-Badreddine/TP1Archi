# TP1Archi
<h1>Question 4 :</h1>
Tout objet dessinable va implémenter l'interface "IObjetDessinable", ensuite la classe "Dessin" va utiliser l'interface "IObjetDessinable" pour manipuler tous les objets dessinables(TrainCercle, Visage...)
<h1>Question 6 :</h1>
Le probléme qui se pose dans la méthode animer() de la classe "Dessin" est que l'Interface "IObjetDessinable" ne possède pas la méthode abstraite "deplacer()" et donc on ne peut pas faire l'appel "o.deplacer()"
<h1>Question 7 :</h1>
On peux ajouter une interface "IObjetAnimable" qui hérite de l'interface "IObjetDessinable" et elle va contenir la méthode abstraite "deplacer()", puis dans la méthode animer() de la classe "Dessin" on appelle la méthode "deplacer()" seulement si l'objet "o" est de type "IObjetAnimable".
<h1>Question 13 :</h1>
Le problème est que dans la classe "Etoile" et "PolygoneRegulier" on va implémenter la méthode "deplacer()" qui doit assurer tous les types de déplacements-->on va utiliser des blocs "if-else if" et chaque bloc implémentera un type de déplacement--->le principe "OCP" sera violé(si on veut ajouter un nouveau type de déplacement on doit modifier le code)
<h1>Question 16 :</h1>
On doit créer une classe concrète pour ce nouveau mouvement d'animation, puis cette classe va implémenter l'interface "IFormeAnimable" et donc elle doit définir la méthode "déplacer(Forme f)" 
