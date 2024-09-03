import './Button.css';

const Button = ({ onClick, type = 'button', className = '' }) => {
  return (
    <button
      type={type}
      className={`custom-button ${className}`}
      onClick={onClick}
    >
      Ver +
    </button>
  );
};

export default Button;