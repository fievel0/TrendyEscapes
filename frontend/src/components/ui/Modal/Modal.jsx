const Modal = ({message, foo, fooMsg, fooB, fooBMsg }) => {
  return (
    <div className="fixed top-0 left-0 w-full h-full bg-gray-900 bg-opacity-50">
      <div className='m-auto relative top-[25%] w-[600px] tablet:w-11/12 bg-white p-10 flex flex-col rounded-lg'>
          <p className='text-center text-3xl mb-4'>{message}</p>
          <button className="w-[200px] m-auto py-2 px-4 border border-solid rounded-lg bg-gray-800 text-white" onClick={foo}>
            <p>{fooMsg}</p>
          </button>

          {
              fooB && <button className="w-[200px] m-auto py-2 px-4 border border-solid rounded-lg bg-gray-800 text-white" onClick={fooB}>
                <p>{fooBMsg}</p>
              </button>
          }
      </div>
  </div>
  )
}
export default Modal