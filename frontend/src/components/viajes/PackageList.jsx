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
    <main>
        {loading ? 
            <>
                <Loader/> :
                {/* colocar 5 cards skeletons */}
                <div className="flex flex-wrap justify-center gap-4 my-4">
                    {Array.from({length: 5}, (_, i) => <CardSkeleton key={i} />)}                
                </div> 
                
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