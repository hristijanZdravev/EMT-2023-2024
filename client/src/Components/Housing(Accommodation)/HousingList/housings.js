import React, { Component } from 'react';
import ReactPaginate from 'react-paginate'
import HousingTerm from '../HousingTerm/housingTerm';
import {Link} from 'react-router-dom';

class Housings extends Component {
    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 3
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.housings.length / this.state.size);
        const housings = this.getHousingsPage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Host</th>
                                <th scope={"col"}>Number of rooms</th>
                            </tr>
                            </thead>
                            <tbody>
                            {housings}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-4">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-primary"} to={"/accommodations/add"}>Add new product</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back"}
                               nextLabel={"next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        console.log(selected)
        this.setState({
            page: selected
        })
    }

    getHousingsPage = (offset, nextPageOffset) => {
        return this.props.housings.map((term, index) => {
            return (
                <HousingTerm  
                key={term.id} // Unique key prop
                term={term}
                onDelete={this.props.onDelete}
                onRent={this.props.onRent}
                 onEdit={this.props.onEdit}
                />
            );
        }).filter((item, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

}

export default Housings;