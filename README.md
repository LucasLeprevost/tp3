# Compte rendu TP3 - Projet Java Git Collaboratif

## 1. Clonage et synchronisation du dépôt

- **Porthos** : Accepte l'invitation GitHub d’Athos.
- **Tous** : Cloner le dépôt dans `~/courseGIT` :
  ```bash
  git clone git@github.com:<utilisateur_de_athos>/tp3.git
  ```
- **Vérification** :
  ```bash
  ls
  # Doit afficher : tp1  tp2  tp3
  ```

## 2. Initialisation du projet

- **Porthos** : Copier `README.md` et `src/Cryptomonnaie.java` de `tp2` à `tp3` (sans copier `.git`). Puis :
  ```bash
  git add .
  git commit -m "Mise à jour fichiers depuis tp2"
  git push
  ```
- **Athos** : Faire un `git pull` pour récupérer les modifications de Porthos.

## 3. Ajout des fichiers de base

- **Athos** : Copier les fichiers suivants dans `tp3/src` :
  - `CryptoMarche.java`
  - `Portefeuille.java`
  - `TestCryptoMarche.java`
  Puis :
  ```bash
  git add .
  git commit -m "Ajout des fichiers de base pour le marché"
  git push
  ```

- **Porthos** : Faire un `git pull` pour obtenir les fichiers.

## 4. Implémentation des classes

- **Athos** : Implémenter dans `CryptoMarche.java` :
  - `capitalEnEuros(String proprietaire)`
  - `capitalMonneaie(Cryptomonnaie monnaie)`

- **Porthos** : Implémenter dans `Portefeuille.java` :
  - `transfertDevise(Portefeuille destination, double montantJetons)`
  - `achatDevise(double montantEuros)`

- **Tous** : Compiler et exécuter les tests :
  ```bash
  javac src/*.java
  java -cp src TestCryptoMarche
  ```
  Objectif : Tous les tests doivent passer (`... OK`).

## 5. Utilisation des branches Git

### Création d'une branche de test

```bash
git branch      # Vérifie les branches
git checkout -b test
touch test.txt
git add test.txt
git commit -m "fonction de test ajoutée"
```

### Retour à la branche principale et modification

```bash
git checkout main
echo "Nous avons maintenant créé une nouvelle branche de test" >> README.md
git add README.md
git commit -m "nouveau commit sur la branche principale"
```

### Visualisation de l’historique

```bash
git log --graph --oneline --all --decorate --topo-order
```

### Fusion de la branche test dans main

```bash
git checkout main
git merge test
```

## 6. Vérification finale

```bash
git log --graph --oneline --all --decorate --topo-order
ls    # test.txt doit maintenant être présent dans main
```

---

**Fin du TP3 :** Tous les fichiers sont en place, les fonctionnalités implémentées et les branches utilisées correctement.
