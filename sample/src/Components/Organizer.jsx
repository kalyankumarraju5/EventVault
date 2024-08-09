import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Card } from 'react-bootstrap';

function Organizer() {
    const [showModal, setShowModal] = useState(false);
    const handleClose = () => setShowModal(false);
    const handleShow = () => setShowModal(true);

    const [showOrganizers, setShowOrganizers] = useState(false);  
    const [organizers, setOrganizers] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [organizer, setOrganizer] = useState({ id: null, name: "" });
    const [selectedOrganizerId, setSelectedOrganizerId] = useState(null);

    useEffect(() => {
        if (showOrganizers) {
            fetchOrganizers();
        }
    }, [showOrganizers]);

    const fetchOrganizers = async () => {
        try {
            const response = await fetch("http://localhost:8081/organizer");
            const data = await response.json();
            setOrganizers(data);
        } catch (error) {
            console.error("Error fetching organizers:", error);
        }
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setOrganizer({
            ...organizer,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const method = organizer.id ? "PUT" : "POST";
        const url = organizer.id ? `http://localhost:8081/organizer/${organizer.id}` : "http://localhost:8081/organizer";
        try {
            const response = await fetch(url, {
                method: method,
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(organizer)
            });
            if (response.ok) {
                console.log("Operation successful!");
                fetchOrganizers();
                setOrganizer({ id: null, name: "" });
                handleClose();
                setSelectedOrganizerId(null);
            } else {
                console.error("Failed operation:", response.statusText);
            }
        } catch (error) {
            console.error("Error:", error);
        }
    };

    const handleDelete = async (id) => {
        try {
            const response = await fetch(`http://localhost:8081/organizer/${id}`, {
                method: "DELETE"
            });
            if (response.ok) {
                console.log("Organizer deleted successfully!");
                fetchOrganizers();
            } else {
                console.error("Failed to delete organizer:", response.statusText);
            }
        } catch (error) {
            console.error("Error deleting organizer:", error);
        }
    };

    const handleSelectOrganizer = (id) => {
        setSelectedOrganizerId(id === selectedOrganizerId ? null : id);
    };

    const startEdit = (organizer) => {
        setOrganizer(organizer);
        handleShow();
    };

    return (
        <div>
            <Button variant="primary" onClick={handleShow}>Add New Organizer</Button>
            <Button variant="info" onClick={() => setShowOrganizers(!showOrganizers)}>
                {showOrganizers ? 'Hide Organizers' : 'View All Organizers'}
            </Button>
            {showOrganizers && (
                <div>
                    <input
                        type="text"
                        placeholder="Search organizers..."
                        value={searchQuery}
                        onChange={e => setSearchQuery(e.target.value)}
                        className="form-control my-3"
                    />
                    <div className="card-container">
                        {organizers.filter(org => 
                            org.name.toLowerCase().includes(searchQuery.toLowerCase())
                        ).map(org => (
                            <Card key={org.id} className="organizer-card" onClick={() => handleSelectOrganizer(org.id)}>
                                <Card.Body>
                                    <Card.Title>{org.name}</Card.Title>
                                    {selectedOrganizerId === org.id && (
                                        <>
                                            <Button variant="secondary" onClick={() => startEdit(org)}>Edit</Button>
                                            <Button variant="danger" onClick={() => handleDelete(org.id)}>Delete</Button>
                                        </>
                                    )}
                                </Card.Body>
                            </Card>
                        ))}
                    </div>
                </div>
            )}
            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>{organizer.id ? 'Update Organizer' : 'Add an Organizer'}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control type="text" name="name" value={organizer.name} placeholder="Enter Name" onChange={handleInputChange} required />
                        </Form.Group>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>Close</Button>
                            <Button variant="primary" type="submit">{organizer.id ? 'Update' : 'Add'}</Button>
                        </Modal.Footer>
                    </Form>
                </Modal.Body>
            </Modal>
        </div>
    );
}

export default Organizer;
