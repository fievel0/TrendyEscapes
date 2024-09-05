import React from "react";
import { MdOutlineTravelExplore } from "react-icons/md";

const Navbar = () => {
  return (
    <header class="bg-secundary">
      <nav
        class="mx-auto flex max-w-7xl items-center justify-between p-6 lg:px-8"
        aria-label="Global"
      >
        <div class="flex lg:flex-1">
          <a href="#" class="-m-1.5 p-1.5">
            <span class="sr-only">Your Company</span>
            <MdOutlineTravelExplore class="h-8 w-auto" />
          </a>
        </div>
        <div class="flex lg:hidden">
          <button
            type="button"
            class="-m-2.5 inline-flex items-center justify-center rounded-md p-2.5 text-gray-700"
          >
            <span class="sr-only">Open main menu</span>
            <svg
              class="h-6 w-6"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              aria-hidden="true"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"
              />
            </svg>
          </button>
        </div>
        <div class="hidden lg:flex lg:gap-x-12">
          <a href="#" class="text-sm font-semibold leading-6 text-gray-900">
            Comunidad
          </a>
          <a href="#" class="text-sm font-semibold leading-6 text-gray-900">
            Paquetes
          </a>
          <a href="#" class="text-sm font-semibold leading-6 text-gray-900">
            Contacto
          </a>
        </div>
        <div class="hidden lg:flex lg:flex-1 lg:justify-end">
          <div class="flex space-x-2">
            <button class="bg-white rounded-xl p-2 text-gray-900 hover:bg-primary hover:text-gray-700 transition duration-300 ease-in-out">
              Log in
            </button>
            <button class="bg-primary rounded-xl p-2 text-gray-900 hover:bg-white hover:text-gray-700 transition duration-300 ease-in-out">
              Register <span aria-hidden="true">&rarr;</span>
            </button>
          </div>
        </div>
      </nav>
    </header>
  );
};

export default Navbar;
