import React, { useState } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

function Ticket() {
    const [showModal, setShowModal] = useState(false);
    const handleClose = () => setShowModal(false);
    const handleShow = () => setShowModal(true);

    const [ticket, setTicket] = useState({
        eventTitle: "",
        attendeeName: "",
        price: ""
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setTicket({
            ...ticket,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch("http://localhost:8081/ticket", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(ticket)
            });
            if (response.ok) {
                console.log("Ticket added successfully!");
                setTicket({ eventTitle: "", attendeeName: "", price: "" });
                handleClose();
            } else {
                console.error("Failed to add ticket:", response.statusText);
            }
        } catch (error) {
            console.error("Error adding ticket:", error);
        }
    };

    return (
        <div>
            <Button variant="primary" onClick={handleShow}>Add Ticket</Button>
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add a Ticket</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group>
                            <Form.Label>Event Title</Form.Label>
                            <Form.Control type="text" name="eventTitle" value={ticket.eventTitle} placeholder="Enter Event Title" onChange={handleInputChange} required />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Attendee Name</Form.Label>
                            <Form.Control type="text" name="attendeeName" value={ticket.attendeeName} placeholder="Enter Attendee Name" onChange={handleInputChange} required />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Price</Form.Label>
                            <Form.Control type="text" name="price" value={ticket.price} placeholder="Enter Price" onChange={handleInputChange} required />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>Close</Button>
                    <Button variant="primary" type="submit">Add</Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default Ticket;
