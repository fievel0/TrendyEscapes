import { Link } from "react-router-dom";

// eslint-disable-next-line react/prop-types
const PackageCard = ({ packageData }) => { 
  // eslint-disable-next-line react/prop-types
  const { id, title, subtitle, description, price, hotel, photo } = packageData;

  return (
    <div className="max-w-sm rounded-2xl overflow-hidden shadow-lg bg-white border border-gray-300">
      <div className="h-[5rem] flex flex-col w-full pt-4 px-4 mb-2">
        <h2 className="text-xl font-bold">{title}</h2>
        <h3 className="text-sm text-gray-500">{subtitle}</h3>
      </div>
      <img className="w-full h-48 object-cover" src={photo} alt={description} />
      <div className="px-6 py-4 flex flex-col h-[15rem] justify-between">
        <div className="mb-2 font-light text-sm">{description}</div>
        <p className="text-gray-700 text-base font-bold">
          {hotel ? 'Hotel Incluido' : 'Hotel No Incluido'}
        </p>
      </div>
      <div className="px-6 pt-4 pb-2 flex items-center justify-end">
        <p className="text-gray-900 font-semibold text-lg">${price}</p>
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


