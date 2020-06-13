# SpringBoot REST API Twitter OOP
Un Web Service è un sistema software in grado di mettersi al servizio di un Client (applicazione, sito web, Postman), comunicando tramite il protocollo HTTP. Un Web service consente quindi agli utenti che vi si collegano di usufruire delle funzioni che mette a disposizione.

L'applicazione sviluppata è una REST API che, prelevati un gruppo di Tweet italiani e tedeschi, ne effettui l'analisi sulla lingua e sulla localizzazione dei Tweet. Inoltre sono implementate le funzionalità di Filtraggio & Statistiche, sulla coerenza tra la lingua e la locazione dei Tweet analizzati.

# Come Usare L'Applicazione
L'applicazione può essere usata in due modi:
- Tramite eseguibile;
- Tramite IDE.

**Tramite eseguibile**
- Scaricare il codice sorgente;
- Aprirlo su un IDE preferito (consigliamo Eclipse);
- Cliccare il tasto destro del mouse sul progetto;
- Scegliere la voce Run Us ---> Maven buil (come da immagine);
![IDE](https://user-images.githubusercontent.com/48152637/84568764-f15cd200-ad81-11ea-9718-e0b5063bb54a.png)

- Nella voce Goals, scrivere 'package' (come in figura);
![MavenBuild](https://user-images.githubusercontent.com/48152637/84567818-7a243f80-ad7b-11ea-81c5-3d93e9262588.png)

- Infine premere su Run.

Dopo di ciò partirà la generazione del codice eseguibile, attendere qualche secondo (al massimo 3 minuti).
Se tutto è andato bene, apparirà la scritta 'Build Success' (come in figura), quindi si potrà usare il file eseguibile jar.
![Build Success Maven](https://user-images.githubusercontent.com/48152637/84567972-a55b5e80-ad7c-11ea-93d1-cd249d8d728f.png)

Per iniziare ad usare l'applicazione tramite il pacchetto distribuibile .jar, bisogna posizionarsi nella root dell'applicazione (ovvero la cartella dove è stato scaricato il codice sorgente da GitHub, oppure dove è stata spostata).

Per lanciare l'applicazione bisogna:

1) Aprire il prompt dei comandi;
2) Posizionarsi sulla root dell'applicazione (..\..\ProgettoOOP) (come da immagine);
![CMD1](https://user-images.githubusercontent.com/48152637/84568427-b9548f80-ad7f-11ea-8d7f-618d3615a75a.png)

3) Verificare che la cartella Target sia presente e riempita (con le classi) prima di generare l'eseguibile, tramite il comando 'dir' (CMD Windows); inoltre si potrà vedere anche dall'ambiente IDE che la cartella è piena (come da immagini);
![CMD4](https://user-images.githubusercontent.com/48152637/84568461-ef920f00-ad7f-11ea-977e-8172d42b2899.png)
![Cartella Target](https://user-images.githubusercontent.com/48152637/84568552-72b36500-ad80-11ea-992e-7f5d73f78acf.png)

4) Lanciare il comando java -jar target/ProgettoOOP-0.0.1-SNAPSHOT.jar, e se tutto va bene partirà l'applicazione SpringBoot (come da immagine);
![CMD3](https://user-images.githubusercontent.com/48152637/84568537-544d6980-ad80-11ea-87e3-70e5a74b022c.png)

5) Usare l'applicazione tramite un API Testing.

**Tramite IDE**
- Scaricare il codice sorgente;
- Aprirlo su un IDE preferito (consigliamo Eclipse);
- Cliccare il tasto destro del mouse sul progetto;
- Scegliere la voce Run Us ---> SpringBoot Application (come da immagine);
![IDE1](https://user-images.githubusercontent.com/48152637/84568695-7bf10180-ad81-11ea-8222-26f8690fc485.png)

- Una volta avviato il servizio, se tutto va bene, si potrà vedere nella console del prompt di comandi che è stato avviato un servizio Tomcat in ascolto sulla posta 8080, ed è stato insterito sull'applicazione un Tomcat di tipo Embedded, quindi un Web Server.
Come da immagine:
![Tomcat Started](https://user-images.githubusercontent.com/48152637/84364271-288b8180-abd0-11ea-9d78-647d051bae82.png)

In questo modo si possono effettuare le chiamate al Web Service tramite le rotte specificate nella sezione successiva.

Per testare l'applicazione tramite API Testing bisogna:
1) Inserire nell'URL dell'API Testing (in questo caso Postman) l'indirizzo della propria macchina (localhost);
2) Inserire la porta di ascolto (8080);
```
URL di base:  localhost:8080
```
3) Inserire la rotta desiderata (es: /Data);
```
URL di esempio:  localhost:8080/Data
```
4) Inserire il tipo di richiesta (GET o POST);
5) Inserire eventuali parametri richiesti;
6) Premere Send.

Ecco degli esempi di chiamate effettuate con Postman,con i rispettivi risultati:
- Chiamata GET
![Esempio Richiesta Get](https://user-images.githubusercontent.com/48152637/84366945-d9475000-abd3-11ea-86d3-0d71f4aa335e.png)

- Chiamata POST
![Esempio Richiesta POST](https://user-images.githubusercontent.com/48152637/84366988-e5331200-abd3-11ea-8dc5-39161ef4e754.png)


# Rotte Applicazione
Per eseguire la richiesta GET o POST si deve necessariamente installare un programma di API Testing; consigliamo Postman.

La seguente tabella mostra le rotte che l'applicazione gestisce:
Tipo | Rotta | Descrizione
---- | ---- | ----
GET | /Data?tipo=lingua | Effettua l'analisi su un gruppo di Tweet Italiani e Tedeschi in base alla lingua.
GET | /Data?tipo=location | Effettua l'analisi su un gruppo di Tweet Italiani e Tedeschi in base alla locazione.
GET | /Stats?tipo=IT | Effettua le statistiche (lingua e locazione) su un gruppo di Tweet Italiani.
GET | /Stats?tipo=DE | Effettua le statistiche (lingua e locazione) su un gruppo di Tweet Tedeschi.
POST | /Filter | Effettua il filtraggio dei Tweet rispettando le condizioni specificate nel body della richiesta.

Nella rotte vi è un parametro chiamato "tipo" che identifica la tipologia di analsi ove si vuole effettuare:
1) Sezione /Data
- "tipo": lingua - Ovvero verrà effettuata l'analisi su base lingua;
- "tipo": location - Ovvero verrà effettuata l'analisi su base localizzazione.

2) Sezione /Stats
- "tipo": IT - Ovvero verranno effettuate le statistiche (su base lingua e localizzazione) dei Tweet Italiani;
- "tipo": DE - Ovvero verranno effettuate le statistiche (su base lingua e localizzazione) dei Tweet Tedeschi.

Per quanto riguarda riguarda la richiesta POST i parametri devono essere necessariamente specificati nel corpo (body) della richiesta.
Il formato del corpo deve essere di tipo JSON.

Le richieste possibili per il filtraggio dei Tweet sono le seguenti:
- Filtraggio Tweet aventi Lingua Italiana & Localizzazione Italiana.
```
{
    "Lang":"it",
    "Location":"IT"
}
```
- Filtraggio Tweet aventi Lingua Italiana & Localizzazione Tedesca.
```
{
    "Lang":"it",
    "Location":"DE"
}
```
- Filtraggio Tweet aventi Lingua Tedesca & Localizzazione Italiana.
```
{
    "Lang":"de",
    "Location":"IT"
}
```
- Filtraggio Tweet aventi Lingua Tedesca & Localizzazione Tedesca.
```
{
    "Lang":"de",
    "Location":"DE"
}
```
Altre tipologie di parametri inseriti ed un errata scrittura del body della richiesta non produrranno alcun risultato, quindi si prega di aver accortezza nella creazione del filtro nel body.

# Possibili Eccezioni
Alle volte è possibile che il risultato della chiamata alle API di Twiiter non restituisca alcun Tweet avente lingua Italiana o Tedesca, poiché Twitter imposta un massimo di Tweet restituiti a chiamata di 100.

Quindi quando si utilizza l'applicazione, in caso di mancanza di Tweet Italiani o Tedeschi, verrà mostrato un messaggio sull'applicazione di API Testing, che indicherà che è avvenuta un'eccezione.

I possibili messaggi di eccezione sono i seguenti:

- Eccezioni sull'analisi (/Data)
```
{
    "TWEET SU BASE LINGUA", "";
    "Tweet Italiani":"0",
    "Tweet Tedeschi":"0"
}
```
```
{
    "TWEET SU BASE LOCAZIONE", "";
    "Tweet Italiani":"0",
    "Tweet Tedeschi":"0"
}
```

- Eccezioni sulle statistiche (/Stats)
```
{
    "STATISTICA ABORTITA", "";
    "Tweet Italiani":"0",
    "Tweet Tedeschi":"0"
}
```

- Eccezioni sul filtraggio (/Filter)
```
{
    "FILTRAGGIO ABORTITO", "";
    "Tweet Italiani":"0",
    "Tweet Tedeschi":"0"
}
```

Un'altra possibile eccezione si può trovare quando si effettuano troppe chiamate nell'arco di poco tempo. Perchè Twitter regolamenta un massimo di 180 chiamate nel giro di 15 minuti.

Superato il numero di queste chiamate, ogni volta che si effettuerà un nuova chiamata uscirà il codice di errore 429 (too much request) e non restituirà nessun Tweet. 

Quando si verifica questo evento nella risposta della chiamata fatta dall'utente tramite l'API Testing, gli verrà mostrato solamente i messaggi delle possibili eccezioni, come mostrato precedentemente, a seconda della rotta da egli scelta. Quinidi anche con questa possibile eccezione, il programma non si bloccherà.

Per ovviare a tale problematica (codice 429) bisogna aspettare un paio di minuti prima di effettuare delle nuove chiamate.

Per maggiori informazioni su questa eccezione, visitare il seguente link:
https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets

# UML

## Diagramma Dei Casi D'Uso
![Diagramma Casi D'uso ProgettoOOP](https://user-images.githubusercontent.com/48152637/84308439-d8c0a200-ab5e-11ea-8963-07d95de05fbf.png)

## Diagramma Delle Classi

### Package Main
![(MAIN)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84301017-6b5b4400-ab53-11ea-8442-e021aab8eb1a.png)

-------------------------------------------------------------------------------------------------------------------------------------------

### Package Controller
![(CONTROLLER)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84503389-66fd6b00-acba-11ea-99c3-13505b77c6af.png)


-------------------------------------------------------------------------------------------------------------------------------------------

### Package Model
![(MODEL)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84301107-92197a80-ab53-11ea-8f34-8bbdafd3fb9f.png)

----------------------------------------------------------------------------------------------------------------------------------------

### Package Utils
![(UTILS)Diagramma Classi ProgettoOOP (1)](https://user-images.githubusercontent.com/48152637/84307781-c003bc80-ab5d-11ea-82a6-036ed815d800.png)

----------------------------------------------------------------------------------------------------------------------------------------

### Package Services
![(SERVI)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84301201-b07f7600-ab53-11ea-9b22-3512d7ef3c69.png)

----------------------------------------------------------------------------------------------------------------------------------------

### Package Filters
![(FILTRI)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84301246-c1c88280-ab53-11ea-9449-766e8aa0122e.png)

----------------------------------------------------------------------------------------------------------------------------------------

### Package Statistics
![(STATS)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84301274-cd1bae00-ab53-11ea-8ff1-4d146bd98532.png)

----------------------------------------------------------------------------------------------------------------------------------------

### Package Exception
![(EXCEP)Diagramma Classi ProgettoOOP](https://user-images.githubusercontent.com/48152637/84301308-dad13380-ab53-11ea-91af-377e30b803f8.png)


## Diagramma Delle Sequenze
- Chiamata /Data?tipo=lingua

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.

Il Controller richiamerà il metodo analisiLinguaTweet() della classe CountTweet, si preleverà tutti i Tweet con la lingua IT e DE, e restituirà l'oggetto di tipo JSON alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(DATA_LINGUA)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84387655-a614b900-abf3-11ea-8ced-8bd56e36dd6b.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Data?tipo=location

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.

Il Controller richiamerà il metodo analisiLocationTweet() della classe CountTweet, si preleverà tutti i Tweet con la localizzazione IT e DE, e restituirà l'oggetto di tipo JSON alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(DATA_LOCATION)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84387724-bf1d6a00-abf3-11ea-80fa-34dd5185072f.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Stats?tipo=IT

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.


Dopo aver ricevuto l'oggetto JSON contenente i Tweet Italiani e Tedeschi, il Controller creerà un'istanza della classe Stast, così da poter utilizzare i metodi che calcolano le statistiche.

Successivamente questa istanza richiama il metodo getStats() della classe StatsUtils, che si occuperà di calcolcare la statstica dei Tweet Italiani.

Una volta fato ciò, la classe rimanderà l'oggetto JSON che contiene le statistiche alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(STATS_IT)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84387780-d3616700-abf3-11ea-8427-85d94e1cd955.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Stats?tipo=DE

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.


Dopo aver ricevuto l'oggetto JSON contenente i Tweet Italiani e Tedeschi, il Controller creerà un'istanza della classe Stast, così da poter utilizzare i metodi che calcolano le statistiche.

Successivamente questa istanza richiama il metodo getStats() della classe StatsUtils, che si occuperà di calcolcare la statstica dei Tweet Tedeschi.

Una volta fato ciò, la classe rimanderà l'oggetto JSON che contiene le statistiche alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(STATS_DE)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84387804-dbb9a200-abf3-11ea-96a3-6bc2f301a854.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Filter
- Body 
```
{
    "Lang":"it",
    "Location":"IT"
}
```

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.


Dopo aver ricevuto l'oggetto JSON contenente i Tweet Italiani e Tedeschi, il Controller creerà un'istanza della classe Filter, così da poter utilizzare i metodi che filtrano i Tweet.

Successivamente questa istanza richiama il metodo filtersTweet() della classe FilterUtils, che si occuperà di filtrare i Tweet aventi lingua Italiana e localizzazione Italiana.

Una volta fato ciò, la classe rimanderà l'oggetto JSON che contiene i Tweet filtrati alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(FILTER_IT-IT)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84387842-eb38eb00-abf3-11ea-887e-7b696aab619d.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Filter
- Body 
```
{
    "Lang":"it",
    "Location":"DE"
}
```

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.


Dopo aver ricevuto l'oggetto JSON contenente i Tweet Italiani e Tedeschi, il Controller creerà un'istanza della classe Filter, così da poter utilizzare i metodi che filtrano i Tweet.

Successivamente questa istanza richiama il metodo filtersTweet() della classe FilterUtils, che si occuperà di filtrare i Tweet aventi lingua Italiana e localizzazione Tedesca.

Una volta fato ciò, la classe rimanderà l'oggetto JSON che contiene i Tweet filtrati alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(FILTER_IT-DE)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84388043-36eb9480-abf4-11ea-87bb-44c2b9e44379.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Filter
- Body 
```
{
    "Lang":"de",
    "Location":"IT"
}
```

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.


Dopo aver ricevuto l'oggetto JSON contenente i Tweet Italiani e Tedeschi, il Controller creerà un'istanza della classe Filter, così da poter utilizzare i metodi che filtrano i Tweet.

Successivamente questa istanza richiama il metodo filtersTweet() della classe FilterUtils, che si occuperà di filtrare i Tweet aventi lingua Tedesca e localizzazione Italiana.

Una volta fato ciò, la classe rimanderà l'oggetto JSON che contiene i Tweet filtrati alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(FILTER_DE-IT)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84388081-48cd3780-abf4-11ea-9fe5-e9ddd12afc50.png)

----------------------------------------------------------------------------------------------------------------------------------------

- Chiamata /Filter
- Body 
```
{
    "Lang":"de",
    "Location":"DE"
}
```

Il Controller effettua una chiamata al metodo getTweet() della classe DownloadTweet, per la restituzione del risutato dalle API.
Successivamente la classe DownloadTweet richiama il metodo Building, che costruisce il nostro ArrayList di Tweet modellato secondo la nostra struttura, restiuisce questo ArrayList di tipo Tweet alla classe chiamante (DownloadTweet).

La classe DownloadTweet richiama il metodo ParsingToJSON della classe ParsingJSON, che si occupa di trasformare l'ArrayList in un oggetto di tipo JSON.
Successivamente questo oggetto JSON ritorna alla classe chiamante (DownloadTweet) ed infine al Controller.


Dopo aver ricevuto l'oggetto JSON contenente i Tweet Italiani e Tedeschi, il Controller creerà un'istanza della classe Filter, così da poter utilizzare i metodi che filtrano i Tweet.

Successivamente questa istanza richiama il metodo filtersTweet() della classe FilterUtils, che si occuperà di filtrare i Tweet aventi lingua Tedesca e localizzazione Tedesca.

Una volta fato ciò, la classe rimanderà l'oggetto JSON che contiene i Tweet filtrati alla classe chiamante (Controller).

Infine il Controller restiuirà il risultato della chiamata API all'applicazione di API Testing.

![(FILTER_DE-DE)Diagramma Delle Sequenze](https://user-images.githubusercontent.com/48152637/84388115-52ef3600-abf4-11ea-93d5-c7eb424f2f50.png)

# Autori
- Nicola Ricciardi - Contributo 50%
- Michele Pio Rendina - Contributo 50%
