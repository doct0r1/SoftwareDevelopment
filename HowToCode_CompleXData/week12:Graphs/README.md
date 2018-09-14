# Graphs Module

Many forms of information naturally organize themselves into trees of various kinds. But what about transit maps, wiring diagrams, the internet, or even secret underground passages? Most of these have one or two key properties that make them be graphs instead of trees. One property is that there are more than one arrows that lead into some node, the other is that the arrows can form cycles.

Once again, this module is in many ways an exercise in what you have already learned. We will start with this new form of information, then use HtDD and HtDF to quickly design powerful functions that operate on graphs.

## Learning Goals

- Be able to identify when domain information naturally forms a graph.
- Be able to write data definitions for graphs.
- Be able to construct cyclic data.
- Be able to design templates that operate on graphs, using accumulators to prevent chasing infinite cycles in the graph.
- Be able to design functions that operate on graphs.
