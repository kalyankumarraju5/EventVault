import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Card } from 'react-bootstrap';

function Event() {
    const [showModal, setShowModal] = useState(false);
    const handleClose = () => setShowModal(false);
    const handleShow = () => setShowModal(true);

    const [showEvents, setShowEvents] = useState(false);
    const [events, setEvents] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [event, setEvent] = useState({ id: null, title: "", description: "" });
    const [selectedEventId, setSelectedEventId] = useState(null);

    useEffect(() => {
        if (showEvents) {
            fetchEvents();
        }
    }, [showEvents]);

    const fetchEvents = async () => {
        try {
            const response = await fetch("http://localhost:8081/event");
            const data = await response.json();
            setEvents(data);
        } catch (error) {
            console.error("Error fetching events:", error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setEvent({
            ...event,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const method = event.id ? "PUT" : "POST";
        const url = event.id ? `http://localhost:8081/event/${event.id}` : "http://localhost:8081/event";
        try {
            const response = await fetch(url, {
                method: method,
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(event)
            });
            if (response.ok) {
                console.log("Operation successful!");
                fetchEvents();
                setEvent({ id: null, title: "", description: "" });
                handleClose();
                setSelectedEventId(null);
            } else {
                console.error("Failed operation:", response.statusText);
            }
        } catch (error) {
            console.error("Error:", error);
        }
    };

    const handleDelete = async (id) => {
        try {
            const response = await fetch(`http://localhost:8081/event/${id}`, {
                method: "DELETE"
            });
            if (response.ok) {
                console.log("Event deleted successfully!");
                fetchEvents();
            } else {
                console.error("Failed to delete event:", response.statusText);
            }
        } catch (error) {
            console.error("Error deleting event:", error);
        }
    };

    const handleSelectEvent = (id) => {
        setSelectedEventId(id === selectedEventId ? null : id);
    };

    const startEdit = (event) => {
        setEvent(event);
        handleShow();
    };

    return (
        <div>
            <Button variant="primary" onClick={handleShow}>Add New Event</Button>
            <Button variant="info" onClick={() => setShowEvents(!showEvents)}>
                {showEvents ? 'Hide Events' : 'View All Events'}
            </Button>
            {showEvents && (
                <div className="card-container">
                    <input
                        type="text"
                        placeholder="Search events..."
                        value={searchQuery}
                        onChange={e => setSearchQuery(e.target.value)}
                        className="form-control my-3"
                    />
                    {events.filter(e => e.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
                        e.description.toLowerCase().includes(searchQuery.toLowerCase())).map(e => (
                        <Card key={e.id} className="event-card" onClick={() => handleSelectEvent(e.id)}>
                            <Card.Body>
                                <Card.Title>{e.title}</Card.Title>
                                <Card.Text>{e.description}</Card.Text>
                                {selectedEventId === e.id && (
                                    <>
                                        <Button variant="secondary" onClick={() => startEdit(e)}>Edit</Button>
                                        <Button variant="danger" onClick={() => handleDelete(e.id)}>Delete</Button>
                                    </>
                                )}
                            </Card.Body>
                        </Card>
                    ))}
                </div>
            )}
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>{event.id ? 'Update Event' : 'Add an Event'}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group>
                            <Form.Label>Title</Form.Label>
                            <Form.Control type="text" name="title" value={event.title} placeholder="Enter Title" onChange={handleInputChange} required />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Description</Form.Label>
                            <Form.Control as="textarea" rows={3} name="description" value={event.description} placeholder="Enter Description" onChange={handleInputChange} required />
                        </Form.Group>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>Close</Button>
                            <Button variant="primary" type="submit">{event.id ? 'Update' : 'Add'}</Button>
                        </Modal.Footer>
                    </Form>
                </Modal.Body>
            </Modal>
        </div>
    );
}

export default Event;
