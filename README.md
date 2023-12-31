# Evaluation Sujet Bibliothèque virtuelle

## Prérequis

- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Maven](https://maven.apache.org/install.html)

## Lancement

### Lancement de la base de données et de l'application

```shell
docker-compose up -d
```

Si jamais vous avez une erreur, il suffit de lancer uniquement la base de données et de relancer l'application.

```shell
docker-compose up -d db
mvn spring-boot:run
```

### Utilisation de l'API

L'API est accessible à l'adresse suivante : http://localhost:8080/api

### Lancement des tests

```shell
mvn test
```

### Arrêt de l'application

```shell
docker-compose down
```

## Documentation

La liste des routes est disponible dans le dossier [docs](docs/REST.md)\*

## Architecture

### Architecture technique

L'application est découpé en Model, Repository, Service et Controller.
C'est ce qu'on appelle une architecture en couches.

Models : Les modèles représentent les données de l'application. Ils sont utilisés par les Repository et les Services.
Repository : Les repositories sont des interfaces qui permettent de faire des requêtes à la base de données.
Service : Les services sont des classes qui permettent de faire des traitements sur les données.
Controller : Les controllers sont des classes qui permettent de faire le lien entre les routes et les services.

### Architecture de la base de données

La base de données est composée de 4 tables : Books, Authors, Users and Loans.

Books : La table Books contient les informations des livres.
Authors : La table Authors contient les informations des auteurs.
Users : La table Users contient les informations des utilisateurs.
Loans : La table Loans contient les informations des emprunts.
