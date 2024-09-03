import { useEffect, useState } from 'react'
import packages from '../db/packages.json'
import Loader from '../components/ui/Loader/Loader';
import PackageCard from '../components/viajes/PackageCard';
import Footer from '../components/ui/Footer/Footer';

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
    <>
        <main>
            {loading ? 
                <Loader/> : 
                <div className="flex flex-wrap justify-center gap-4 my-4">
                    {pkgs.map((pkg) => (
                        <PackageCard key={pkg.id} packageData={pkg} />
                    ))}
                </div>            
            }
        </main>
        <Footer/>
    </>
    
  )
}
export default PackageList