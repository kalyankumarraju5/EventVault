import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Card } from 'react-bootstrap';

function Attendee() {
    const [showModal, setShowModal] = useState(false);
    const handleClose = () => setShowModal(false);
    const handleShow = () => setShowModal(true);

    const [showAttendees, setShowAttendees] = useState(false);  
    const [attendees, setAttendees] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [attendee, setAttendee] = useState({ id: null, name: "", email: "" });
    const [selectedAttendeeId, setSelectedAttendeeId] = useState(null);

    useEffect(() => {
        if (showAttendees) {
            fetchAttendees();
        }
    }, [showAttendees]);

    const fetchAttendees = async () => {
        try {
            const response = await fetch("http://localhost:8081/attendee");
            const data = await response.json();
            setAttendees(data);
        } catch (error) {
            console.error("Error fetching attendees:", error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setAttendee({
            ...attendee,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const method = attendee.id ? "PUT" : "POST";
        const url = attendee.id ? `http://localhost:8081/attendee/${attendee.id}` : "http://localhost:8081/attendee";
        try {
            const response = await fetch(url, {
                method: method,
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(attendee)
            });
            if (response.ok) {
                console.log("Operation successful!");
                fetchAttendees();
                setAttendee({ id: null, name: "", email: "" });
                handleClose();
                setSelectedAttendeeId(null);
            } else {
                console.error("Failed operation:", response.statusText);
            }
        } catch (error) {
            console.error("Error:", error);
        }
    };

    const handleDelete = async (id) => {
        try {
            const response = await fetch(`http://localhost:8081/attendee/${id}`, {
                method: "DELETE"
            });
            if (response.ok) {
                console.log("Attendee deleted successfully!");
                fetchAttendees();
            } else {
                console.error("Failed to delete attendee:", response.statusText);
            }
        } catch (error) {
            console.error("Error deleting attendee:", error);
        }
    };

    const handleSelectAttendee = (id) => {
        setSelectedAttendeeId(id === selectedAttendeeId ? null : id);
    };

    const startEdit = (attendee) => {
        setAttendee(attendee);
        handleShow();
    };

    return (
        <div>
            <div className="button-container">  {/* Using button-container for styling separation and hover effect */}
                <Button variant="primary" onClick={handleShow}>Add New Attendee</Button>
                <Button variant="info" onClick={() => setShowAttendees(!showAttendees)}>
                    {showAttendees ? 'Hide Attendees' : 'View All Attendees'}
                </Button>
            </div>
            {showAttendees && (
                <div className="card-container">
                    <input
                        type="text"
                        placeholder="Search attendees..."
                        value={searchQuery}
                        onChange={e => setSearchQuery(e.target.value)}
                        className="form-control my-3"
                    />
                    {attendees.filter(att =>
                        att.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
                        att.email.toLowerCase().includes(searchQuery.toLowerCase())
                    ).map(att => (
                        <Card key={att.id} className="attendee-card" onClick={() => handleSelectAttendee(att.id)}>
                            <Card.Body>
                                <Card.Title>{att.name}</Card.Title>
                                <Card.Text>{att.email}</Card.Text>
                                {selectedAttendeeId === att.id && (
                                    <>
                                        <Button variant="secondary" onClick={() => startEdit(att)}>Edit</Button>
                                        <Button variant="danger" onClick={() => handleDelete(att.id)}>Delete</Button>
                                    </>
                                )}
                            </Card.Body>
                        </Card>
                    ))}
                </div>
            )}
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>{attendee.id ? 'Update Attendee' : 'Add an Attendee'}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control type="text" name="name" value={attendee.name} placeholder="Enter name" onChange={handleInputChange} required />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" name="email" value={attendee.email} placeholder="Enter email" onChange={handleInputChange} required />
                        </Form.Group>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>Close</Button>
                            <Button variant="primary" type="submit">{attendee.id ? 'Update' : 'Add'}</Button>
                        </Modal.Footer>
                    </Form>
                </Modal.Body>
            </Modal>
        </div>
    );
}

export default Attendee;
