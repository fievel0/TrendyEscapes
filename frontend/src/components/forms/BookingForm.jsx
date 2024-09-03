import React, { useState } from 'react';


//Usamos useState para gestionar los datos del formulario. El objeto formData contiene los valores de todos los campos del formulario.
const BookingForm = ({ packageTypes, onSubmit }) => {
  const [formData, setFormData] = useState({
    name: '',
    contact: '',
    date: '',
    tipoPaquete: '',
    transporte: false,
    pais: '',
    ciudad: '',
  });

  // Handle input changes - Actualiza el estado cada vez que cambia una entrada del formulario.
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === 'checkbox' ? checked : value,
    });
  };

  // Handle form submission , handlesubmit - Impide el envío del formulario por defecto, y llama a la función onSubmit (pasada como prop) con los datos del formulario.
  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  return (
    <form onSubmit={handleSubmit} className="max-w-lg mx-auto p-6 bg-white shadow-md rounded">
      <h2 className="text-2xl font-bold mb-4">Reserve su Paquete de Viaje</h2>
      
      {/* Name Input */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2" htmlFor="name">
          Nombre:
        </label>
        <input
          type="text"
          id="name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
          className="w-full px-3 py-2 border rounded"
        />
      </div>
      
      {/* Contact Input */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2" htmlFor="contact">
          Contacto:
        </label>
        <input
          type="text"
          id="contact"
          name="contact"
          value={formData.contact}
          onChange={handleChange}
          required
          className="w-full px-3 py-2 border rounded"
        />
      </div>
      
      {/* Date Input */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2" htmlFor="date">
          Fecha de Reserva:
        </label>
        <input
          type="date"
          id="date"
          name="date"
          value={formData.date}
          onChange={handleChange}
          required
          className="w-full px-3 py-2 border rounded"
        />
      </div>
      
      {/* Tipo Paquete Dropdown */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2" htmlFor="tipoPaquete">
          Tipo de Paquete:
        </label>
        <select
          id="tipoPaquete"
          name="tipoPaquete"
          value={formData.tipoPaquete}
          onChange={handleChange}
          required
          className="w-full px-3 py-2 border rounded"
        >
          <option value="">Seleccione un paquete</option>
          {packageTypes.map((type) => (
            <option key={type.id} value={type.id}>
              {type.description}
            </option>
          ))}
        </select>
      </div>
      
      {/* Transporte Checkbox */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2">
          <input
            type="checkbox"
            name="transporte"
            checked={formData.transporte}
            onChange={handleChange}
            className="mr-2"
          />
          Incluir Transporte
        </label>
      </div>
      
      {/* Country Input */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2" htmlFor="pais">
          País:
        </label>
        <input
          type="text"
          id="pais"
          name="pais"
          value={formData.pais}
          onChange={handleChange}
          required
          className="w-full px-3 py-2 border rounded"
        />
      </div>
      
      {/* City Input */}
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2" htmlFor="ciudad">
          Ciudad:
        </label>
        <input
          type="text"
          id="ciudad"
          name="ciudad"
          value={formData.ciudad}
          onChange={handleChange}
          required
          className="w-full px-3 py-2 border rounded"
        />
      </div>
      
      {/* Submit Button */}
      <button type="submit" className="bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700">
        Reservar Ahora
      </button>
    </form>
  );
};

export default BookingForm;