import React, { useReducer, createContext } from 'react';
import { Form } from "./componentes/Form"
import { List } from "./componentes/List"
import { reducer } from "./reducer"

export const HOST_API = "http://localhost:8080/api";
const initialState = {
  todo: { list: [], item: {} }
};
export const Store = createContext(initialState)

const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);
  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>

}

function App() {
  return <div className="container col-4 mt-5"> 
    <StoreProvider>
      <h3>To-Do List</h3>
      <hr/>
        <Form />
        <div className="card-flex">
          <div className="table col-8">
            <List />
          </div>
        </div>
    </StoreProvider>
  </div>
}

export default App;
