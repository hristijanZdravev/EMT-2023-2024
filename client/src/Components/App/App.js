import React, { Component } from 'react';
import HousingService from '../../Enviroments/housingRepository'; 
import Header from '../Header/header';
import HousingAdd from '../Housing(Accommodation)/HousingAdd/housingAdd';
import Housings from '../Housing(Accommodation)/HousingList/housings';
import HousingEdit from '../Housing(Accommodation)/HousingEdit/housingEdit';
import Categories from '../Category/categories';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';




class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      housings: [],
      categories : [],
      hosts : [],
      selectedHousing: {}

    };
  }

  componentDidMount() {
    this.loadHousing();
    this.loadCategories();
    this.loadHosts();
  }

loadCategories = () =>{
HousingService.fetchHousingCatagories().then((data) => {
  this.setState({
    categories: data.data
  })
});
}

loadHosts = () =>{
  HousingService.fetchHost().then((data) => {
    this.setState({
      hosts: data.data
    })
  });
  }

  loadHousing = () => {
    HousingService.fetchHousing()
    .then((data) => {
        this.setState({
          housings: data.data
        })
    });

  }

  deleteHousing = (id) => {
    HousingService.deleteHousing(id)
        .then(() => {
            this.loadHousing();
        });
   }

   addHousing = (name, category, hostId, numRooms) => {
    HousingService.addHousing(name, category, hostId, numRooms)
        .then(() => {
            this.loadHousing();
        });
}

editHousing = (id, name, category, hostId, numRooms) => {
  HousingService.editHousing(id, name, category, hostId, numRooms)
      .then(() => {
          this.loadHousing();
      });
}

getHousing = (id) => {
  HousingService.getHousing(id)
      .then((data) => {
          this.setState({
            selectedHousing: data.data
          })
      })
}

rentHousing = (id) => {
  HousingService.rentHousing(id)
      .then(() => {
          this.loadHousing();
      });
 }



  render() {


    return (
  
      <Router>
      <Header/>
      <main>
      <div>
      <Routes>     
      <Route path="/categories" element={<Categories categories={this.state.categories}/>} />
      <Route path="/accommodations/edit/:id" element={<HousingEdit hosts={this.state.hosts} categories={this.state.categories}  onEditProduct={this.editHousing} housing={this.state.selectedHousing}/>} />
      <Route path="/accommodations/add" element={<HousingAdd hosts={this.state.hosts} categories={this.state.categories} onAddHousing={this.addHousing}/>} />
      <Route path="/accommodations" element={<Housings  housings={this.state.housings} onRent={this.rentHousing} onDelete={this.deleteHousing}  onEdit={this.getHousing}/>} />
      <Route path="*" element={<Navigate to="/accommodations" />} />
      </Routes>
      </div>
 </main>
  
 </Router>

    );
  }


}
export default App;