import axios from 'axios';

const API_BASE_URL = 'http://localhost:8081';

export const fetchAttendees = () => axios.get(`${API_BASE_URL}/attendee`);
export const createAttendee = (attendee) => axios.post(`${API_BASE_URL}/attendee`, attendee);
export const updateAttendee = (id, attendee) => axios.put(`${API_BASE_URL}/attendee/${id}`, attendee);
export const deleteAttendee = (id) => axios.delete(`${API_BASE_URL}/attendee/${id}`);

export const fetchEvents = () => axios.get(`${API_BASE_URL}/event`);
export const fetchOrganizers = () => axios.get(`${API_BASE_URL}/organizer`);
export const fetchTickets = () => axios.get(`${API_BASE_URL}/ticket`);
