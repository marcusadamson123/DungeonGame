# 🎮 PROJEKTI KIRJELDUS


## 👤 AUTORID
- Marcus Adamson
- Nikolas Arro

## 🧩 PROJEKTI PÕHIKIRJELDUS

**Mis see on?**  
See projekt on tekstipõhine RPG dungeon-mäng, kus mängija liigub läbi koobaste ja kohtub erinevate vastastega.

**Mis on eesmärk?**  
Eesmärk on ellu jääda, võidelda koletistega ja läbida mäng edukalt.

**Mida programm teeb?**  
Programm genereerib juhuslikke sündmusi, võimaldab võidelda erinevate koletistega ning hallata mängija seisundit.


## ⚙️ PROGRAMMI TÖÖ JA KASUTUSJUHIS

**Käivitamine:**  
Programm käivitatakse läbi Main klassi.

**Peamised tegevused:**  
- Mängija liigub läbi koopasüsteemi  
- Kohtub juhuslike sündmustega  
- Võitleb erinevate koletistega
- Kogub võimalikut palju kulda 

**Lõpetamine:**  
Mäng lõppeb, kui mängija elu saab otsa või kõik sündmused on läbitud.


##  KLASSID JA STRUKTUUR

### 📦 Klass: Main
- **Eesmärk:** Programmi käivitamine
- **Olulisemad meetodid:**
  - `main()` – alustab mängu

---

### 📦 Klass: Mäng
- **Eesmärk:** Mänguloogika haldamine
- **Olulisemad meetodid:**
  - mängutsükli juhtimine
  - sündmuste käivitamine

---

### 📦 Klass: Mängija
- **Eesmärk:** Esindab mängijat
- **Olulisemad omadused:**
  - elu
  - rünnak
- **Olulisemad meetodid:**
  - ründamine
  - kahju saamine

---

### 📦 Klass: Koletis (superklass)
- **Eesmärk:** Koletise loogika ja nende atribuudid.
- **Alamklassid:**
  - Ork
  - Vampiir
  - Zombi
  - Skelett
  - Lohe

---

### 📦 Klass: Ork / Vampiir / Zombi / Skelett / Lohe
- **Eesmärk:** Erinevad vaenlased mängus
- **Omadused:**
  - erinev elu ja rünnak
- **Käitumine:**
  - ründavad mängijat

---

### 📦 Klass: Koobas
- **Eesmärk:** Mängu keskkond (dungeon)
- **Funktsioon:** hoiab sündmusi ja liikumist

---

### 📦 Klass: Sündmus
- **Eesmärk:** Juhuslike sündmuste kirjeldamine
- **Näited:**
  - võitlus
  - rahulik olukord

---

### 📦 Klass: JuhuslikkuseAbi
- **Eesmärk:** Juhuslike arvude genereerimine
- **Kasutus:**
  - sündmuste valik
  - rünnaku varieerumine

---

## 👥 TIIMITÖÖ JA PANUS

- **Marcus:** Mäng klassi tegemine ja mängu loogika kirjutamine.
- **Nikolas:** Teiste klasside tegemine ja mängu loogika kirjutamine.

---

## ⚠️ PROBLEEMID JA LAHENDUSED

- Probleem: erinevate klasside omavaheline suhtlus  
  Lahendus: kasutati pärimist

- Probleem: juhuslikkus mängus  
  Lahendus: loodi eraldi JuhuslikkuseAbi klass

---

## ⭐ HINNANG JA ARENDUS

**Mis läks hästi?**  
- Klasside struktuur on loogiline  
- Mäng töötab ja on mängitav  
- Erinevad vaenlased muudavad mängu huvitavaks  

**Mida saaks parandada?**  
- Lisada graafiline kasutajaliides  
- Rohkem sündmusi  
- keerulisem võitlussüsteem  

---

## 🧪 TESTIMINE

- Testiti mängu käivitamist  
- Testiti võitlussituatsioone erinevate koletistega  
- Kontrolliti, et mäng lõppeb õigesti  

---

## 💡 LISASELGITUSED

Projekt kasutab objektorienteeritud programmeerimist:
- pärimine (Koletis → alamklassid)
- kapseldamine (andmete hoidmine klassides)
- loogiline struktuur

---
