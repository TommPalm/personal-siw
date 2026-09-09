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
        return <p>Caricamento...</p>;
    }

    if (error) {
        return <p className="error">{error}</p>;
    }

    return (
        <div className="tickets-page">

            <div id="titolo">
                <img
                    src="/images/titleBackground.jpg"
                    id="sfondoTitolo"
                    alt="Sfondo"
                />

                <strong id="pageName">
                    🚗 DOTTOR VEICOLO: TICKETS 🩺
                </strong>
            </div>

            <div className="sottotitolo">

                <h1>Tickets associati a:</h1>

                {car && (
                    <div className="car-info">
                        <span>{car.model}</span>
                        <span>[{car.plate}]</span>
                    </div>
                )}

            </div>

            {tickets.length === 0 ? (

                <p>
                    Spiacenti, non risultano ticket aperti
                    per questa vettura nei nostri registri
                </p>

            ) : (

                <ul>
                    {tickets.map((ticket) => (

                        <li key={ticket.id}>

                            <strong>Operazione:</strong>
                            <span>{ticket.description}</span>

                            <strong>Stato:</strong>
                            <span>{ticket.state}</span>

                            <strong>Tempo stimato:</strong>
                            <span>{ticket.estimatedTime}</span>

                            <strong>Costo:</strong>
                            <span>
                                {Number(ticket.cost).toFixed(2)}
                            </span>

                        </li>

                    ))}
                </ul>

            )}

            <a href="/personal" id="login">
                Area personale
            </a>

        </div>
    );
}

const root = ReactDOM.createRoot(
    document.getElementById("root")
);

root.render(<Tickets />);
