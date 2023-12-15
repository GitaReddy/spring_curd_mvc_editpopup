<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Display Students</title>
    <link rel="stylesheet" href="https://cdn.syncfusion.com/ej2/material.css" />
</head>
<body>
    <h2>Student Data</h2>

    <div id="grid"></div>

    <script src="https://cdn.syncfusion.com/ej2/dist/ej2.min.js"></script>
    <script>
    document.addEventListener('DOMContentLoaded', function () {

        var laptopsData = [];
        var selectedRecords = []; // Declare selectedRecords at a higher scope

        // Initialize the DataGrid
        ej.grids.Grid.Inject(ej.grids.Edit, ej.grids.Toolbar);
        var grid = new ej.grids.Grid({
            dataSource: laptopsData,
            editSettings: { allowEditing: true, allowDeleting: true,allowAdding: true, mode: 'Dialog', height: 500 },
            toolbar: ['Add', 'Edit', 'Delete',],
            columns: [
                { field: 'id', headerText: 'ID', isPrimaryKey: true },
                { field: 'brand', headerText: 'BRAND' },
                { field: 'price', headerText: 'PRICE' },
                
                
            ],

            allowPaging: true,
            gridLines: 'Both',
            allowSorting: true,

            actionComplete: function (args) {
                if (args.requestType === 'save') {
                    // The 'save' requestType indicates that an add, edit, or delete operation was performed
                    if (args.action === 'add') {
                        // If it was an 'add' action, send the new record to the server to add to the database
                        addLaptop(args.data);
                    } else if (args.action === 'edit') {
                        // If it was an 'edit' action, send the updated record to the server to update the database
                        updateLaptopData(args.data);
                    }
                }
            }

        });

       
        function fetchLaptopsData() {
           
            fetch('/alllaptops')
                .then(response => response.json())
                .then(data => {
                    console.log('Data received:', data);

                    
                    grid.dataSource = data;
                    grid.refresh();
                })
                .catch(error => {
                    console.error('Error fetching data:', error);
                });
        }

        // Function to add a new student
        function addLaptop(laptop) {
            fetch('/addlaptop', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(laptop),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Laptop added successfully:', data);
                    // Fetch updated data after adding a new student
                    fetchLAptopsData();
                })
                .catch(error => {
                    console.error('Error adding laptop:', error);
                });
        }
        

        function updateLaptopData(updatedLaptop) {
            fetch('/updateLaptop/' + updatedLaptop.id, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(updatedLaptop),
            })
                .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('Error updating laptop: ' + response.statusText);
                    }
                })
                .then(data => {
                   
                    console.log('Laptop updated successfully:', data);
                    fetchLaptopsData(); 
                })
                .catch(error => {
                    console.error('Error updating laptop:', error.message);
                });
        }

        grid.toolbarClick = function (args) {
            if (args.item.id === 'grid_delete') {
               
                var selectedRecords = grid.getSelectedRecords();

                if (selectedRecords.length > 0) {
                    
                    fetch('/deleteLaptop/' + selectedRecords[0].id, {
                        method: 'POST',
                    })
                        .then(response => response.text())
                        .then(message => {
                            console.log(message);
                            
                            fetchLaptopsData();
                        })
                        .catch(error => {
                            console.error('Error deleting record:', error);
                        });
                } else {
                    console.warn('No records selected for deletion');
                }
            }
        };

        // Render the DataGrid
        grid.appendTo('#grid');

        // Automatically fetch data when the DOM content is loaded
        fetchLaptopsData();

    });

    </script>
</body>
</html>
