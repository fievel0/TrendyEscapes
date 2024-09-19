import { Link } from "react-router-dom";

const PackageCard = ({ packageData }) => { 
  const { id, nombre, tipoPaquete, descripcion, costo, hotel, foto, ciudades, pais } = packageData;

  return (
    <div className="max-w-sm rounded-2xl overflow-hidden shadow-lg bg-white border border-gray-300">
      <div className="h-[5rem] flex flex-col w-full pt-4 px-4 mb-2">
        <h2 className="text-xl font-bold">{nombre}</h2>
        <h3 className="text-sm text-gray-500">{tipoPaquete}</h3>
        <h4 className="text-sm text-gray-500">{ciudades} - {pais}</h4>
      </div>
      <img className="w-full h-48 object-cover" src={`/Images/packages${foto}`} alt={descripcion} />
      <div className="px-6 py-4 flex flex-col h-[15rem] justify-between">
        <div className="mb-2 font-light text-sm">{descripcion}</div>
        <p className="text-gray-700 text-base font-bold">
          {hotel ? 'Hotel Incluido' : 'Hotel No Incluido'}
        </p>
      </div>
      <div className="px-6 pt-4 pb-2 flex items-center justify-end">
        <p className="text-gray-900 font-semibold text-lg">${costo}</p>
        <button          
          className="ml-4 bg-primary text-white font-bold py-2 px-4 rounded-xl hover:shadow"
        >
          <Link to={`/packages/${id}`}>Ver +</Link>
        </button>
      </div>
    </div>
  );
};

export default PackageCard;


