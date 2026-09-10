console.log("Tickets.jsx CARICATO");
console.log("carId =", carId);

const { useEffect, useState } = React;

function Tickets() {

    const [car, setCar] = useState(null);
    const [tickets, setTickets] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    useEffect(() => {

        fetch(`/api/cars/${carId}/tickets`, {
            credentials: "include"
        })
            .then((response) => {

                if (!response.ok) {
                    throw new Error(
                        "Errore nel caricamento dei ticket"
                    );
                }

                return response.json();
            })
            .then((data) => {
                setCar(data.car);
                setTickets(data.tickets);
                setLoading(false);
            })
            .catch((error) => {
                console.error(error);
                setError("Impossibile caricare i ticket");
                setLoading(false);
            });

    }, []);

    if (loading) {
        return (
            <div className="loading-card">
                <div className="loading-icon">🔄</div>
                <h2>Caricamento ticket...</h2>
                <p>Attendi mentre recuperiamo le informazioni della vettura.</p>
            </div>
        );
    }

    if (error) {
        return (
            <div className="empty-message">
                <div style={{ fontSize: "40px" }}>⚠️</div>
                <h2>Si è verificato un problema</h2>
                <p className="error">{error}</p>
                <a href="/personal" className="btn btn-primary">
                    ← Torna all'area personale
                </a>
            </div>
        );
    }

    return (
        <div className="tickets-page">

            <header id="titolo">

                <img
                    src="/images/titleBackground.jpg"
                    id="sfondoTitolo"
                    alt="Sfondo officina"
                />

                <strong id="pageName">
                    🚗 DOTTOR VEICOLO: TICKETS 🩺
                </strong>

                <a href="/personal" id="login">
                    Area personale
                </a>

            </header>


            <main>

                <section className="ticket-car-header">

                    <div className="sottotitolo">

                        <h1>🎫 Ticket associati a</h1>

                        {car && (
                            <div className="car-info">
                                <span>{car.model}</span>
                                <span className="plate-badge">
                                    {car.plate}
                                </span>
                            </div>
                        )}

                    </div>

                </section>


                {tickets.length === 0 ? (

                    <div className="empty-message">

                        <div style={{ fontSize: "45px" }}>
                            ✅
                        </div>

                        <h2>Nessun ticket aperto</h2>

                        <p>
                            Spiacenti, non risultano ticket aperti
                            per questa vettura nei nostri registri.
                        </p>

                        <a
                            href="/personal"
                            className="btn btn-primary">
                            ← Torna alle mie auto
                        </a>

                    </div>

                ) : (

                    <section className="ticket-list">

                        {tickets.map((ticket) => (

                            <article
                                className="ticket-card"
                                key={ticket.id}>

                                <div className="ticket-header">

                                    <span className="ticket-number">
                                        Ticket #{ticket.id}
                                    </span>

                                    <span className="ticket-status">
                                        {ticket.state}
                                    </span>

                                </div>


                                <div className="ticket-body">

                                    <div className="ticket-row">

                                        <span className="ticket-label">
                                            🔧 Operazione
                                        </span>

                                        <span className="ticket-value">
                                            {ticket.description}
                                        </span>

                                    </div>


                                    <div className="ticket-row">

                                        <span className="ticket-label">
                                            ⏱️ Tempo stimato
                                        </span>

                                        <span className="ticket-value">
                                            {ticket.estimatedTime}
                                        </span>

                                    </div>


                                    <div className="ticket-row">

                                        <span className="ticket-label">
                                            💰 Costo
                                        </span>

                                        <span className="ticket-cost">
                                            € {Number(ticket.cost).toFixed(2)}
                                        </span>

                                    </div>

                                </div>

                            </article>

                        ))}

                    </section>

                )}


                <div className="ticket-back">

                    <a
                        href="/personal"
                        className="btn btn-primary">
                        ← Torna all'area personale
                    </a>

                </div>

            </main>

        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById("root")
);

root.render(<Tickets />);
