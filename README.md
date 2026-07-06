# personal-siw
repository per il progetto personale di siw
è il sistema di gestione degli ordini di un'officina e dei suoi utenti. il sistema deve memorizzare e tenere conto di diversi fattori:

CLIENTE: possiedono un username, una password. un cliente può visualizare la sua auto e le task correnti e/o passate ad essa associate

IMPIEGATO: possiedono username, password e ruolo. un impiegato può avere ruolo di meccanico o dirigente
 - un meccanico può visualizzare le task a cui è stato assegnato e modificarne lo stato di avanzamento. inoltre prendere/riporre attrezzi e richiedere l'uso di ricambi (riducendone il numero in magazzino)
 - un dirigente può visualizzare tutte le informazioni, creare task (assegnando descrizione e meccanico), aggiungere attrezzi e/o ricamb al magazzino (ordinandoli). i dirigenti sono anche meccanici

TASK: possiedono codice, descrizione problema, stato di avanzamento, data ingresso, preventivo, data completamento, meccanico assegnato. ogni task è riferita ad un'automobile

AUTO: targa, modello, paese immatricolazione. ogni auto è riferita ad un proprietario e mantiene memoria con tutte le task passate che la riguardano

ATTREZZO: possiede codice identificativo, nome, postazione, disponibilità (si/no)

RICAMBI: possiedono nome, codice identificativo, produttore, quantità disponibile in magazzino
