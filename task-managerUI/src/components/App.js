import React, { Component } from "react";

import '../styles/App.css';
import ControlledTabs from './ControlledTabs.js';
import Example from './Example.js';
import Example1 from './Example1.js';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

class App extends React.Component {
    render() {
        return (
            <div>
                <h1>Task Manager</h1>
               { /*alert("test")*/}
			{/*	<ControlledTabs />*/}
              <Example />
              <ToastContainer />
              {/*  <Example1 />*/}*/}
            </div>
        );
    }
}

export default App;
