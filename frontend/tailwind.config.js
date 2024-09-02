/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {  
    fontFamily: {
      'sans': ['"Inter"', 'sans-serif']
    },  
    extend: {      
      colors: {
        'primary': '#FF9500',
      },
      screens: {
        notebook: {max: '1280px'},
        tablet: {max: '1024px'},
        mobile: {max: '768px'},
      }
    },
  },
  plugins: [],
}

