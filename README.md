# ws.politicians

Politician and social media SOAP and REST web service

members of the group :
-COURTIN Florent (florent95.courtin@gmail.com)
-FLEUTRY Eva (eva.fleutry@gmail.com)

Notre sujet avait pour objectif d’ajouter et récupérer des informations concernant des politiciens et leur parti politique.
Nous avions plusieurs critères à respecter :
Services web 
•	Créer un service SOAP et un service REST avec pour chaque au moins deux méthodes
•	Possibilité de créer une base de donnée pour récupérer les informations
Client 
•	Appeler toutes les méthodes du service créé avec un seul client
•	Faire appel à une API pour un des services (REST ou SOAP)
Pour la réalisation de ce projet, nous avons utilisé les frameworks JAX-WS,JAX-RS et Apache CXF et  le serveur d’application Apache Tomcat 9.


PARTIE SOAP

Le service permet d'ajouter des politiciens à un tableau de politiciens et d'utiliser les fonctions fournies pour retirer ou chercher des éléments dans ce tableau.

Le client généré depuis un wsdl file permet de mettre en pratique ces fonctions. 

PARTIE REST

Service qui permet de recuperer et ajouter des informations sur des politiciens et leur parti en utilisant l'API REST NosDeputes.fr (documentation : https://github.com/regardscitoyens/nosdeputes.fr/blob/master/doc/api.md)

Les données saisies sont ensuite sauvegardées dans une base de donnée mySQL
Le client permet ensuite d'utiliser les fonctions du service web qui retournent des objets Politician ou PoliticalParty pour les méthodes GET et des objets Response pour les autres.

Ces services web SOAP et REST permettent recenser les hommes/femmes politiques ainsi que leur parti politique afin d'accéder plus facilement à leurs informations ( dans le cas où on veut créer un site avec les dernières publications Twitter de chaque politique grâce à leur identifiant Twitter soit rentré manuellement soit récupéré via l'API NosDeputes





