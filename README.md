# personal-siw
repository per il progetto personale di siw

sistema che gestisce il sistema di assegnazione e gestione task di un'officina. il sistema tiene traccia di Task, Meccanici, Dirigenti, Automobili e Tickets.
- le Task (nome, descrizione, codice meccanico) sono le varie consegne che possono essere visualizzate dai lavoratori dell'officina e vengono assegnate ad un particolare meccanico
- i Meccanici (nome, cognome, codice) visualizzano quali task somo loro assegnate e possono accedere in visualizzazione, ma non  possono editare le richieste
- i Dirigenti (nome, cognome, codice) possono visualizzare le task e le automobili con la possibilità di modificare le task per assegnarle
- le Automobili (targa, modello, problema, stato) rimangono in archivio fino a che non sono pronte alla riconsegna, possono essere in stato "lavoro" o "pronta" 
- i Ticket (id, cliente, conto) rimangono in archivio, il loro conto può essere classificato in "aperto" o "chiuso" in base allo stato del pagamento 
