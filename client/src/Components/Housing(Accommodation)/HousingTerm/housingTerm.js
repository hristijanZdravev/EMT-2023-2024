import React from 'react';
import {Link} from 'react-router-dom';

const HousingTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.host.name}</td>
            <td>{props.term.numRooms}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger "}
                   onClick={() => props.onDelete(props.term.id)}
                   >
                    Delete
                </a>
                <Link className={"btn btn-dark ms-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/accommodations/edit/${props.term.id}`}
                      >
                    Edit
                </Link>
                {props.term.isRented ? (
                    <a className='btn btn-secondary ms-2 disabled' role="button" aria-disabled="true" disabled>Rented</a>
                ) : (
                    <a title={"Rent"} className="btn btn-success ms-2"
                    onClick={() => props.onRent(props.term.id)}
                    >
                    Rent
                    </a>
                )}

            </td>
        </tr>
    )
}

export default HousingTerm;
