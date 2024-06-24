# Microservice Cagnotte - BforBank

## Description

Ce projet (Test technique) est un microservice de cagnotte. Le microservice permet de gérer une cagnotte pour les clients de BforBank, qui peuvent ajouter des montants à leur cagnotte lors de passages en caisse, et vérifier la disponibilité de leur cagnotte.

## Data

Quelques exemples d'instructions SQL pour insérer des données initiales dans la base de données à des fins de tests sont placer dans le fichier data.sql du répertoire src/main/resources.

## Utilisation
### ajouter un passage en caisse

**URL:** `http://localhost:8080/api/checkout/record/{ClientId}`  
**Method:** `POST`

**Parameters:**
- `clientId`: Long (Path Variable)

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/cagnotte/check/2"
```
Response: 200 OK en cas de succès.


### Ajouter un montant à la cagnotte

**URL:** `api/cagnotte/add/{clientId}`  
**Method:** `POST`

**Parameters:**
- `clientId`: Long (Path Variable)
- `amount`: BigDecimal (Request Parameter)

**Example Request:**
```bash
curl -X POST "http://localhost:8080/api/cagnotte/add/2?amount=5.00"
```
Response: 200 OK en cas de succès.

### Vérifier la disponibilité de la cagnotte

**URL:** `api/cagnotte/check/{ClientId}`  
**Method:** `GET`

**Parameters:**
- `clientId`: Long (Path Variable)

**Example Request:**
```bash
curl -X GET "http://localhost:8080/api/cagnotte/check/2"
```
Response: 200 OK avec true or false indiquant si la cagnotte est disponible.

### Exemple test

**Client 1 (John Doe):**
- Checkout: 3
- Cagnotte: 10.00€
- Availability: true

**Customer 2 (Jane Smith):**
- Checkout: 2
- Cagnotte: 8.00€
- Availability: false
