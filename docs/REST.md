# API Routes

==========

## Livres

- `GET /books` : Liste tous les livres
- `GET /books/{id}` : Détails d'un livre spécifique
- `GET /books/title/{title}` : Rechercher des livres par titre
- `GET /books/author/{authorName}` : Rechercher des livres par auteur
- `POST /books` : Ajouter un nouveau livre
- `DELETE /books/{id}` : Supprimer un livre

### Auteur

- `GET /authors` : Liste tous les auteurs
- `GET /authors/{id}` : Détails d'un auteur spécifique
- `POST /authors` : Ajouter un nouvel auteur
- `DELETE /authors/{id}` : Supprimer un auteur

### Emprunt

- `GET /loans` : Liste tous les emprunts
- `GET /loans/user/{userId}` : Liste des emprunts d'un utilisateur
- `POST /loans` : Créer un nouvel emprunt

### Utilisateur

- `GET /users` : Liste tous les utilisateurs
- `GET /users/{id}` : Détails d'un utilisateur spécifique
- `POST /users` : Inscrire un nouvel utilisateur
- `DELETE /users/{id}` : Supprimer un utilisateur
