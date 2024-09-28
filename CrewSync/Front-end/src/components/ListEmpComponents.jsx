import React, { useEffect, useState } from 'react'
import { deleteEmployee, listOfEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmpComponents = () => {

    const [employees,setEmployees]=useState([]);
    const navigate = useNavigate();

    useEffect(()=>{
        getAllEmployees();

    },[])

    function getAllEmployees(){
        listOfEmployees().then((response)=>{
            setEmployees(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    function addNewEmp(){
        navigate("/addEmployee")
    }

    function updateEmployee(id){
        navigate(`/update-employee/${id}`)
    }

    function removeEmployee(id){
        deleteEmployee(id).then((response)=>{
            getAllEmployees();

        }).catch(error=>{
            console.log(error);
            
        })
    }

  return (
    <div className='container'>
      <h2 className='text-center'>List of Employees</h2>
      <button className='btn btn-primary mb-2' onClick={addNewEmp}>Add Employee</button>
      <table className='table table-striped table-bordered'>
        <thead>
            <tr>
                <th>Employee Id</th>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee Email Id</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>
            {employees.map(employee =>

                <tr key={employee.id}>

                    <td>{employee.id}</td>
                    <td>{employee.firstName}</td>
                    <td>{employee.lastName}</td>
                    <td>{employee.email}</td>
                    <td>
                        <button className='btn btn-info' onClick={()=>updateEmployee(employee.id)}>Update</button>
                        <button className='btn btn-danger' onClick={()=>removeEmployee(employee.id)}
                            
                            style={{marginLeft:"10px"}}
                            >Delete</button>
                    </td>

                </tr>

            )}
        </tbody>

      </table>
    </div>
  )
}

export default ListEmpComponents
