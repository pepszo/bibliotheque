drop database if exists bibliodb;
CREATE DATABASE bibliodb;
USE bibliodb;

CREATE TABLE Roles
(
	idRole INT primary key auto_increment,
	label NVARCHAR(50) NOT NULL
);

CREATE TABLE Mg
(
	idMg int primary key auto_increment,
    idRole int not null,
	nom NVARCHAR(50) NOT NULL,
	prenom NVARCHAR(50) NOT NULL,
	adresse NVARCHAR(50) NOT NULL,
	dateN DATE NOT NULL,
	email NVARCHAR(200) NOT NULL,
	mdp NVARCHAR(100) NOT NULL,
    CONSTRAINT FK_Mg_Roles FOREIGN KEY(idRole) REFERENCES Roles(idRole)
);

CREATE TABLE Bibliotheques
(
	idBibliotheque INT primary key auto_increment,
	adresse NVARCHAR(50) NOT NULL,
	tel NVARCHAR(15) NOT NULL
);

CREATE TABLE Lecteurs
(
	idLecteur INT primary key auto_increment,
    idRole int not null,
	nom NVARCHAR(50) NOT NULL,
    prenom NVARCHAR(50) NOT NULL,
    adresse NVARCHAR(250) NOT NULL,
    tel NVARCHAR(15) NOT NULL,
	email NVARCHAR(200) NOT NULL,
	mdp NVARCHAR(100) NOT NULL,
    CONSTRAINT FK_Lecteurs_Roles FOREIGN KEY(idRole) REFERENCES Roles(idRole)
);

CREATE TABLE Bibliothecaires
(
	idBibliothecaire INT primary key auto_increment,
    idBibliotheque int not null,
    idRole int not null,
	nom NVARCHAR(50) NOT NULL,
	prenom NVARCHAR(50) NOT NULL,
	adresse NVARCHAR(50) NOT NULL,
	dateN DATE NOT NULL,
	email NVARCHAR(200) NOT NULL,
	mdp NVARCHAR(100) NOT NULL,
    CONSTRAINT FK_Bibliothecaires_Roles FOREIGN KEY(idRole) REFERENCES Roles(idRole),
    CONSTRAINT FK_Bibliothecaires_Bibliotheques FOREIGN KEY(idBibliotheque) REFERENCES Bibliotheques(idBibliotheque)
);

CREATE TABLE Cotisations
(
	idCotisation INT primary key auto_increment,
    idBibliotheque int not null,
    idLecteur int not null,
	dateDebut DATETIME NOT NULL,
	dateFin DATETIME NOT NULL,
	CONSTRAINT FK_Cotisations_Bibliotheques FOREIGN KEY(idBibliotheque) REFERENCES Bibliotheques(idBibliotheque),
	CONSTRAINT FK_Cotisations_Lecteurs FOREIGN KEY(idLecteur) REFERENCES Lecteurs(idLecteur)
);

CREATE TABLE Oeuvres
(
	idOeuvre INT primary key auto_increment,
	isbn NVARCHAR(20) NOT NULL,
	titre NVARCHAR(200) NOT NULL,
	descri NVARCHAR(1000) NOT NULL
);

CREATE TABLE Critiques
(
	idCritique INT primary key auto_increment,
    idLecteur int not null,
    idOeuvre int not null,
	commentaire NVARCHAR(250),
	note FLOAT,
	CONSTRAINT FK_Critiques_Lecteurs FOREIGN KEY(idLecteur) REFERENCES Lecteurs(idLecteur),
	CONSTRAINT FK_Critiques_Oeuvres FOREIGN KEY(idOeuvre) REFERENCES Oeuvres(idOeuvre)
);

CREATE TABLE Editions
(
	idEdition INT primary key auto_increment,
    idOeuvre int not null,
	nomEditeur NVARCHAR(50) NOT NULL,
	dateEdition DATETIME NOT NULL,
    CONSTRAINT FK_Editions_Oeuvres FOREIGN KEY(idOeuvre) REFERENCES Oeuvres(idOeuvre)
);

CREATE TABLE Etats
(
	idEtat INT primary key auto_increment,
    label nvarchar(250) not null
);

CREATE TABLE Exemplaires
(
	idExemplaire INT primary key auto_increment,
    idEdition int not null,
    idBibliotheque int not null,
    idEtat int not null,
	CONSTRAINT FK_Exemplaires_Editions FOREIGN KEY(idEdition) REFERENCES Editions(idEdition),
	CONSTRAINT FK_Exemplaires_Bibliotheques FOREIGN KEY(idBibliotheque) REFERENCES Bibliotheques(idBibliotheque),
    CONSTRAINT FK_Exemplaires_Etats FOREIGN KEY(idEtat) REFERENCES Etats(idEtat)
);

CREATE TABLE Locations
(
	idLocation INT primary key auto_increment,
    idLecteur int not null,
    idExemplaire int not null,
	dateDebut DATE NOT NULL,
	dateFin DATE NOT NULL,
	CONSTRAINT FK_Locations_Lecteurs FOREIGN KEY(idLecteur) REFERENCES Lecteurs(idLecteur),
    CONSTRAINT FK_Locations_Exemplaires FOREIGN KEY(idExemplaire) REFERENCES Exemplaires(idExemplaire)
);

CREATE TABLE Amendes
(
	idAmende INT primary key auto_increment,
	idLecteur INT not null,
	idLocation INT not null,
	motif NVARCHAR(200) NOT NULL,
	montant FLOAT NOT NULL,
	CONSTRAINT FK_Amendes_Lecteurs FOREIGN KEY(idLecteur) REFERENCES Lecteurs(idLecteur),
	CONSTRAINT FK_Amendes_Locations FOREIGN KEY(idLocation) REFERENCES Locations(idLocation)
);


CREATE TABLE Questions
(
	idQuestion INT primary key auto_increment,
    idBibliothecaire int not null,
    idLecteur int not null,
    reponse nvarchar(250) not null,
	CONSTRAINT FK_Questions_Bibliothecaires FOREIGN KEY(idBibliothecaire) REFERENCES Bibliothecaires(idBibliothecaire),
	CONSTRAINT FK_Questions_Lecteur FOREIGN KEY(idLecteur) REFERENCES Lecteurs(idLecteur)
);


INSERT INTO bibliodb.Bibliotheques
           (adresse
           ,tel)
     VALUES
           ('La louvière', '0484475123'),
           ('Haine-Saint-Pièrre', '0484123456'),
           ('Mons', '0486753412');

INSERT INTO bibliodb.Roles
           (label)
     VALUES
           ('Bibliothecaire_Manager_General');           
           
INSERT INTO bibliodb.Roles
           (label)
     VALUES
           ('Bibliothecaire_Manager');
           
INSERT INTO bibliodb.Roles
           (label)
     VALUES
           ('Bibliothecaire');
           
INSERT INTO bibliodb.Roles
           (label)
     VALUES
           ('Lecteur');
           

INSERT INTO bibliodb.Oeuvres
           (isbn
           ,titre
           ,descri)
     VALUES
           ('12568-100', 'Harry Potter à l école des sorciers', 'Le jour de ses onze ans, Harry Potter, un orphelin élevé par un oncle et une tante qui le détestent, voit son existence bouleversée. Un géant vient le chercher pour l emmener au collège Poudlard, école de sorcellerie où une place l attend depuis toujours. Qui est donc Harry Potter? Et qui est l effroyable V..., le mage dont personne n ose prononcer le nom. Amitié, surprises, dangers, scènes comiques, Harry découvre ses pouvoirs et la vie à Poudlard. Le premier tome des aventures du jeune héros vous ensorcelle aussitôt!');
           
INSERT INTO bibliodb.Oeuvres
           (isbn
           ,titre
           ,descri)
     VALUES
           ('13568-200', 'Harry Potter et la Chambre des secrets', 'Une rentrée fracassante en voiture volante, une étrange malédiction qui s abat sur les élèves, cette deuxième année à l école des sorciers ne s annonce pas de tout repos ! Entre les cours de potions magiques, les matchs de Quidditch et les combats de mauvais sorts, Harry et ses amis Ron et Hermione trouveront-ils le temps de percer le mystère de la Chambre des Secrets ?');
           
INSERT INTO bibliodb.Oeuvres
           (isbn
           ,titre
           ,descri)
     VALUES
           ('13568-300', 'Harry Potter et le Prisonnier d Azkaban', 'Harry Potter a quatorze ans et il entre en quatrième année au collège de Poudlard. Une grande nouvelle attend Harry, Ron et Hermione à leur arrivée : la tenue d un tournoi de magie exceptionnel entre les plus célèbres écoles de sorcellerie. Déjà, les délégations étrangères font leur entrée. Harry se réjouit... Trop vite. Il va se trouver plongé au coeur des événements les plus dramatiques qu il ait jamais eu à affronter.'); 
           
INSERT INTO bibliodb.Oeuvres
           (isbn
           ,titre
           ,descri)
     VALUES
           ('13568-400', 'Harry Potter et la Coupe de feu', 'Harry Potter a quatorze ans et entre en quatrième année à Poudlard. Une grande nouvelle attend Harry, Ron et Hermione à leur arrivée : la tenue d un tournoi de magie exceptionnel entre les plus célèbres écoles de sorcellerie. Déjà les délégations étrangères font leur entrée. Harry se réjouit... Trop vite. Il va se trouver plongé au cœur des événements les plus dramatiques qu il ait jamais eu à affronter.');
           
INSERT INTO bibliodb.Oeuvres
           (isbn
           ,titre
           ,descri)
     VALUES
           ('13568-500', 'Harry Potter et l Ordre du phénix', 'À quinze ans, Harry Potter s apprête à entrer en cinquième année à Poudlard. Et s il est heureux de retrouver le monde des sorciers, il n a jamais été aussi anxieux. L adolescence, la perspective des examens importants en fin d année, et ces étranges cauchemars... Car Celui-Dont-On-Ne-Doit-Pas-Prononcer-Le-Nom est de retour et, plus que jamais, Harry sent peser sur lui une terrible menace. Une menace que le ministère de la Magie ne semble pas prendre au sérieux, contrairement à Dumbledore. Poudlard devient alors le terrain d une véritable lutte de pouvoir. La résistance s organise autour de Harry qui va devoir compter sur le courage et la fidélité de ses amis de toujours...');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (1, 'Galimard', '1997-06-26');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (1, 'Galimard jeunesse', '1997-06-26');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (2, 'Galimard', '1998-07-02');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (2, 'Galimard jeunesse', '1998-07-02');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (3, 'Galimard', '1999-07-08');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (3, 'Galimard jeunesse', '1999-07-08');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (4, 'Galimard', '2000-07-08');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (4, 'Galimard jeunesse', '2000-07-08');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (5, 'Galimard', '2003-06-21');
           
INSERT INTO bibliodb.Editions
           (idOeuvre
           ,nomEditeur
           ,dateEdition)
     VALUES
           (5, 'Galimard jeunesse', '2003-06-21');
           

INSERT INTO bibliodb.Etats
           (label)
     VALUES
           ('Bon état');

INSERT INTO bibliodb.Etats
           (label)
     VALUES
           ('Moyen état');
           
INSERT INTO bibliodb.Etats
           (label)
     VALUES
           ('Mauvaise état');

INSERT INTO bibliodb.Exemplaires
           (idBibliotheque
           ,idEdition
           ,idEtat)
     VALUES
           (1, 1, 1);
           
INSERT INTO bibliodb.Exemplaires
           (idBibliotheque
           ,idEdition
           ,idEtat)
     VALUES
           (1, 2, 1);
           
INSERT INTO bibliodb.Exemplaires
           (idBibliotheque
           ,idEdition
           ,idEtat)
     VALUES
           (1, 3, 1);
           
INSERT INTO bibliodb.Exemplaires
           (idBibliotheque
           ,idEdition
           ,idEtat)
     VALUES
           (1, 1, 2),
           (2, 1, 2),
           (3, 1, 2);
           
INSERT INTO bibliodb.Exemplaires
           (idBibliotheque
           ,idEdition
           ,idEtat)
     VALUES
           (1, 2, 2),
           (2, 2, 2),
           (3, 2, 2);
           
INSERT INTO bibliodb.Exemplaires
           (idBibliotheque
           ,idEdition
           ,idEtat)
     VALUES
           (1, 3, 2),
           (2, 3, 2),
           (3, 3, 2);


INSERT INTO bibliodb.Bibliothecaires
           (idBibliotheque
           ,nom
           ,prenom
           ,adresse
           ,dateN
           ,email
           ,mdp
           ,idRole)
     VALUES
           (1,'cambaz', 'mehmet', 'rue victor boch 48', '1995-08-17', 'bi@hotmail.com', '$2a$12$weDJ56k0aiokvci/37AqdusESIxPU0VoksUOxczpsUBOqpXqxlIMe', 3);
           
           INSERT INTO bibliodb.Bibliothecaires
           (idBibliotheque
           ,nom
           ,prenom
           ,adresse
           ,dateN
           ,email
           ,mdp
           ,idRole)
     VALUES
           (1,'cambaz', 'mehmet', 'rue victor boch 48', '1995-08-17', 'ma@hotmail.com', '$2a$12$weDJ56k0aiokvci/37AqdusESIxPU0VoksUOxczpsUBOqpXqxlIMe', 2);
           
INSERT INTO bibliodb.Mg
           (idRole
           ,nom
           ,prenom
           ,adresse
           ,dateN
           ,email
           ,mdp)
     VALUES
           (1,'cambaz', 'mehmet', 'rue victor boch 48', '1995-08-17', 'mg@hotmail.com', '$2a$12$weDJ56k0aiokvci/37AqdusESIxPU0VoksUOxczpsUBOqpXqxlIMe');


INSERT INTO bibliodb.Lecteurs
           (idRole
           ,nom
           ,prenom
           ,adresse
           ,tel
           ,email
           ,mdp)
     VALUES
           (4,'ark', 'burak', 'rue des champs', '0484476123', 'le@hotmail.com', '$2a$12$weDJ56k0aiokvci/37AqdusESIxPU0VoksUOxczpsUBOqpXqxlIMe');



INSERT INTO bibliodb.Locations
           (idLecteur
           ,idExemplaire
           ,dateDebut
           ,dateFin)
     VALUES
           (1,1,'2020-02-01', '2020-03-01');







