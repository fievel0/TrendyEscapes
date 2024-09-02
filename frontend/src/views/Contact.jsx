import { useState } from "react"
import ContactForm from "../components/forms/ContactForm"
import Footer from "../components/ui/Footer/Footer"
import ContactModal from "../components/ui/ContactModal/ContactModal"


const Contact = () => {
    const [modal, setModal] = useState(true)

    const openModal = () => {
        setModal(true)
    }
    
  return (
    <>
        <ContactForm openModal={openModal}/>
        <Footer/>
        {modal && <ContactModal/>}        
    </>
  )
}

export default Contact