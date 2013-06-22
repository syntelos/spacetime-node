
Spacetime Node

  An in-memory implementation of space filling structures for the
  spacetime project

    http://github.com/syntelos/spacetime

  and, using

    http://code.google.com/p/lxl


  The spacetime project is a look into object data code structures for
  spacetime data sets.  Spacetime programming can support algorithms
  in visualization, simulation, and data storage and retrieval.

  As java programming language interfaces, these data code structures
  support degrees of freedom in numeric and storage representation.

  This package presents domain lists with node membership as one way
  to model objects having spacetime attributes.  A node's membership
  is exposed and reflected in the node interface.  

  This work develops previous efforts in the spacetime standalone
  essay,

    http://github.com/syntelos/spacetime-standalone


  Membership domains are defined as java enum types for numeric scalar
  and derivative properties of nodes.

  These lists may be employed in a microscopic way for part nodes in a
  model, or in a macroscopic way over model nodes in a world.


  In the spacetime standalone effort, domain membership lists were
  obscured behind a singular, scene graph like list of lists
  structure.


  Following the spacetime interfaces, each spacetime object node has
  one or more domain locations -- a set which is unique.  These lists
  are sets.

  The node package interfaces present these mathematical sets.


  As a package separate from spacetime, node is distinct like a page
  or chapter of a book.  The separation is provided for the benefit of
  presentation and use.


See also

  http://github.com/syntelos/spacetime
  http://github.com/syntelos/spacetime-standalone
