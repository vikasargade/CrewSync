import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ListEmpComponents from './components/ListEmpComponents'
import HeaderComponents from './components/HeaderComponents'
import FooterComponents from './components/FooterComponents'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import EmployeeComponents from './components/EmployeeComponents'
import Login from './components/Login'
import './Login.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>
        <HeaderComponents/>
          <Routes>
            <Route path='/' element={<ListEmpComponents/>}></Route>
            <Route path='/addEmployee' element={<EmployeeComponents/>}></Route>
            <Route path='/update-employee/:id' element={<EmployeeComponents/>}></Route>
            {/* <Route path='/login' element={<Login/>}></Route> */}
          </Routes>
        <FooterComponents/>
      </BrowserRouter>
    </>
  )
}

export default App
