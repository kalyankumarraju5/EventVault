import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'; // Ensure Bootstrap CSS is imported

import Attendee from './Components/Attendee';
import Event from './Components/Event';
import Organizer from './Components/Organizer';
import Ticket from './Components/Ticket';

function App() {
  // State for storing and filtering data if needed in the future
  const [event, setEvents] = useState([]);
  const [organizer, setOrganizers] = useState([]);
  const [ticket, setTickets] = useState([]);
  const [attendee, setAttendees] = useState([]);

  // Fetch data for all components
  useEffect(() => {
    const fetchData = async () => {
      try {
        const eventResponse = await axios.get('http://localhost:8081/event');
        const organizerResponse = await axios.get('http://localhost:8081/organizer');
        const ticketResponse = await axios.get('http://localhost:8081/ticket');
        const attendeeResponse = await axios.get('http://localhost:8081/attendee');
        
        setEvents(eventResponse.data);
        setOrganizers(organizerResponse.data);
        setTickets(ticketResponse.data);
        setAttendees(attendeeResponse.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <Router>
      <div className="container">
        <h1 className="text-center mt-3">Event Management System</h1>
        <nav className="nav justify-content-center mt-3">
          <Link className="nav-link" to="/attendee">Attendees</Link>
          <Link className="nav-link" to="/event">Events</Link>
          <Link className="nav-link" to="/organizer">Organizers</Link>
          <Link className="nav-link" to="/ticket">Tickets</Link>
        </nav>
        <Routes>
          <Route path="/attendee" element={<Attendee data={attendee} />} />
          <Route path="/event" element={<Event data={event} />} />
          <Route path="/organizer" element={<Organizer data={organizer} />} />
          <Route path="/ticket" element={<Ticket data={ticket} />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
