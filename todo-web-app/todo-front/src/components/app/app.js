import React from 'react';
import Content from "./content";
import Sidebar from "./sidebar";
import Footer from "./footer";
import Header from "./header";

const App = () => {
    return (
        <div className="app">
            <Header/>
            <div className="flex-row">
                <Sidebar/>
                <Content/>
            </div>
            <Footer/>
        </div>
    )
}

export default App;