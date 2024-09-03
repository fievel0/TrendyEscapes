import React from 'react';

const PackageCard = ({ packageData, onReserve }) => {
  const { Descripción, Costo, Hotel, Foto } = packageData;

  return (
    <div className="max-w-sm rounded overflow-hidden shadow-lg bg-white">
      <img className="w-full h-48 object-cover" src={Foto} alt={Descripción} />
      <div className="px-6 py-4">
        <div className="font-bold text-xl mb-2">{Descripción}</div>
        <p className="text-gray-700 text-base">
          {Hotel ? 'Includes Hotel' : 'No Hotel Included'}
        </p>
      </div>
      <div className="px-6 pt-4 pb-2">
        <span className="text-gray-900 font-semibold text-lg">${Costo}</span>
        <button
          onClick={onReserve}
          className="ml-4 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          Reserve Now
        </button>
      </div>
    </div>
  );
};

export default PackageCard;


