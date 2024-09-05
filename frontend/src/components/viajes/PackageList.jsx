import { useEffect, useState } from 'react'
import packages from '../../db/packages.json'
import Loader from '../ui/Loader/Loader';
import PackageCard from '../viajes/PackageCard';
import CardSkeleton from '../skeletons/CardSkeleton/CardSkeleton';

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
    <main className="flex flex-wrap justify-center gap-4 py-4 mb-4 bg-secundary">
        {loading ? 
            <>
                <Loader />
                {Array.from({length: 5}, (_, i) => <CardSkeleton key={i} />)}
            </>:

            pkgs.map((pkg) => (
                <PackageCard key={pkg.id} packageData={pkg} />
            ))
        }          
    </main>
  )
}
export default PackageList