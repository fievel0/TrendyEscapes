import { useEffect, useState } from 'react'
import packages from '../../db/packages.json'
import Loader from '../ui/Loader/Loader';
import PackageCard from '../viajes/PackageCard';

const PackageList = () => {
    const [loading, setLoading] = useState(true)
    const [pkgs, setPkgs] = useState(null)

    useEffect(() => {
        //asincronia para simular llamada a api
        setTimeout(() => {
            setPkgs(packages)
            setLoading(false)            
      }, 1000)
    })

  return (   
    <main>
        {loading ? 
            <>
                <Loader/> :
                {/* reemplzar por skeleton */}
                <div className='w-full h-[calc(100vh-289px)] text-center'> CARGANDO </div>
            </>:
            <div className="flex flex-wrap justify-center gap-4 my-4">
                {pkgs.map((pkg) => (
                    <PackageCard key={pkg.id} packageData={pkg} />
                ))}
            </div>            
        }
    </main>
  )
}
export default PackageList