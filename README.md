## 📖 O projekcie
---

**Automated Parking Management System (APMS)** to projekt symulatora stworzony w ramach zajęć **Programowania Obiektowego**. Aplikacja umożliwia testowanie różnych scenariuszy logistycznych, zarządzanie ruchem pojazdów i miejscami parkingowymi z wykorzystaniem wzorca projektowego State Pattern.


---

## 🚀 Uruchomienie lokalne
---

##  Wymagania
* **Java Development Kit (JDK)** w wersji **17** lub nowszej.
* **Apache Maven** (do budowania projektu, uruchamiania i generowania Javadoc).

##  Instalacja
1. **Sklonuj repozytorium**
   ```bash
   git clone -b develop https://github.com/Qnsay0/apms-parking-simulator.git
   cd apms-parking-simulator
2. **Skompiluj projekt**
   ```bash
   mvn clean compile
3. **Uruchom symulator**
   ```bash
   mvn exec:java -Dexec.mainClass="app.APMSLauncher"
---

## 📚 Dokumentacja API (Javadoc)
---

1. **Wygeneruj plik Javadoc**
   ```bash
   mvn javadoc:javadoc
2. **Otwórz w przeglądarce**
Dla systemu **macOS / Linux**:
   ```bash
   open target/site/apidocs/index.html
Dla systemu **Windows:**
   ```bash
   start target\site\apidocs\index.html
