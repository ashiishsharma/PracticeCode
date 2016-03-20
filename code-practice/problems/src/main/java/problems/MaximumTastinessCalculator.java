package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MaximumTastinessCalculator {

	private static final String PRECISION_FORMAT = "#0.000000000";
	private static final String SPACE = " ";
	private HashMap<String, Double> weightQuantityTastinessMap = new HashMap<String, Double>();	
	
	
	public static void main(String[] args) throws IOException {

		   
		MaximumTastinessCalculator calculator = new MaximumTastinessCalculator();
		   
		   //Reading input and storing 
		   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		   String[] input = reader.readLine().split(MaximumTastinessCalculator.SPACE);
		   short numOfComponents = Short.parseShort(input[0]);
		   short totalWeight = Short.parseShort(input[1]);
		   Component[] components = new Component[numOfComponents];
		   
		   for(int i=0; i < numOfComponents; i++) {
			   input = reader.readLine().split(MaximumTastinessCalculator.SPACE);
			   Component c = null;
			   ComponentType componentType = ComponentType.valueOf(input[0]);
			
			   if(componentType == ComponentType.D) {
				   c = calculator.new Component(componentType, Short.parseShort(input[1]), Double.parseDouble(input[2]), Short.parseShort(input[3]));
			   }else if(componentType == ComponentType.C) {
				   c = calculator.new Component(componentType, (short)1, Double.parseDouble(input[1]), Short.parseShort(input[2]));
			   }
			   
			   components[i] = c;
		   }
		  
	      //Processing on input
	      try {
			  System.out.println(calculator.calculateMaximumTastiness(totalWeight, components));
	      } catch (NoCombinationFoundException e) {
			  System.out.println("Impossible");
	      }
	}

	private String calculateMaximumTastiness(short totalWeight, Component[] components) throws NoCombinationFoundException{

		double maxTastiness = 0;
		short[] weights = getListOfWeights(components);
		Arrays.sort(weights);
		Set<ArrayList<Short>> uniqueWeightsList = new HashSet<ArrayList<Short>>();
		ArrayList<Short> list = new ArrayList<Short>();

		//Get all the unique combinations equal to totalWeight
		getAllUniqueWeightCombinations(weights, totalWeight, 0, (short)0, uniqueWeightsList, list);

		//If no combination found
		if(uniqueWeightsList.size() == 0) {
			throw new NoCombinationFoundException();
		}

		//Iterating over the combinations and returning max tastiness for a combination 
		Iterator<ArrayList<Short>> iter = uniqueWeightsList.iterator();
		while(iter.hasNext()) {
			ArrayList<Short> combinationList = iter.next();
			double tastinessOfThisCombination = getTastinessForThisCombination(combinationList, components);
			if(tastinessOfThisCombination > maxTastiness) {
				maxTastiness = tastinessOfThisCombination;
			}
		}
		
		return new DecimalFormat(PRECISION_FORMAT).format(maxTastiness);
	}

	
	 private double getTastinessForThisCombination(ArrayList<Short> combinationList, Component[] components) {
		
		 //Fetch the map for weight and its counts or quantity in this combination
		 Map<Short, Long> weightQuantityMap = getWeightsQuantityMap(combinationList);
		 double totalTastiness = 0.0;

		 //Iterating over the weights and the quantity map in this combination and finding max tastiness
		 Iterator<Entry<Short, Long>> iter = weightQuantityMap.entrySet().iterator();
		 while(iter.hasNext()) {
			 Entry<Short, Long> entry = (Entry<Short, Long>) iter.next();
			 Short weight = entry.getKey();
			 Long quantity = entry.getValue();
			 totalTastiness += getMaxTastinessFor(weight, quantity, components); 
		 }
		 
		 return totalTastiness;
	}

	private double getMaxTastinessFor(Short weight, Long quantity, Component[] components) {
		
		Double tastiness = weightQuantityTastinessMap.get(weight+quantity+"");
		if(tastiness != null) {
			return tastiness;
		}
		
		double maxTastiness = 0;
		for(Component c: components) {
			if(weight == c.getWeight()) {
				double tastinessOfThisComponent = c.getTastiness(quantity);
				if(tastinessOfThisComponent > maxTastiness) {
					maxTastiness = tastinessOfThisComponent;
					weightQuantityTastinessMap.put(weight+quantity+"", Double.valueOf(maxTastiness));
				}
			}
		}
		
		return maxTastiness;
			
	}

	private Map<Short, Long> getWeightsQuantityMap(ArrayList<Short> combinationList) {
		
		//Counting the weights and its occurences and storing in hashmap
		Map<Short, Long> weightQuantityMap = new HashMap<Short, Long>();
			
		 for(Short weight: combinationList) {
			 if(weightQuantityMap.containsKey(weight)) {
					Long value =  weightQuantityMap.get(weight);
					weightQuantityMap.put(weight,  Long.valueOf(++value ));
				} else{
					weightQuantityMap.put(weight, Long.valueOf(1));
				}
		 }
		 return weightQuantityMap;
	}

	public void getAllUniqueWeightCombinations(short[] weights, short totalWeight, int start, short sum, Set<ArrayList<Short>> result, ArrayList<Short> list) {
		 
		if(sum > totalWeight) {
			return;
		}
		
		for(int i = start; i < weights.length; i++) {
			list.add(weights[i]);
			sum += weights[i];
			if(sum == totalWeight) {
				result.add(new ArrayList<Short>(list));
				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);
				return;
			}
		
			if(sum < totalWeight) {
				getAllUniqueWeightCombinations(weights, totalWeight, i, sum, result, list);
			} else {
				getAllUniqueWeightCombinations(weights, totalWeight, i+1, sum, result, list);
			}
			
			sum -= list.get(list.size() - 1);
			list.remove(list.size() - 1);
		}
	 }
	 
	private short[] getListOfWeights(Component[] components) {
		short[] weights = new short[components.length];
		int i=0;
		for(Component c: components) {
			weights[i++] = c.getWeight();
		}
		return weights;
	}
	
	private enum ComponentType { D, C};
	
	private class Component {

		private ComponentType typeOfComponent;
		private short weight;
		private double tastiness;
		private short decayOfTastiness;
		
		public Component(ComponentType typeOfComponent, short weight,
				double tastiness, short decayOfTastiness) {
			super();
			this.typeOfComponent = typeOfComponent;
			this.weight = weight;
			this.tastiness = tastiness;
			this.decayOfTastiness = decayOfTastiness;
		}
		
		public ComponentType getComponentType() {
			return typeOfComponent;
		}

		public short getWeight() {
			return weight;
		}
		
		public double getTastiness() {
			return tastiness;
		}
		
		public short getDecayOfTastiness() {
			return decayOfTastiness;
		}
		
		public double getTastiness(long quantity) {
			if(typeOfComponent == ComponentType.D) {
				return getDiscreteTastiness(quantity);
			} else if (typeOfComponent == ComponentType.C) {
				return getContinuousTastiness(quantity);
			}
			return 0;
		}
		
		private double getContinuousTastiness(long quantity) {
			return quantity * (tastiness - ((quantity/2.0) * decayOfTastiness ));
		}

		private double getDiscreteTastiness(long quantity) {
			double sum = 0;
			for(int i=0; i < quantity; i++) {
				sum +=  (tastiness - (i * decayOfTastiness));
			}
			return sum;
		}

		@Override
		public String toString() {
			return "Component [decayOfTastiness=" + decayOfTastiness
					+ ", tastiness=" + tastiness + ", typeOfComponent="
					+ typeOfComponent + ", weight=" + weight + "]";
		}
		
	}
	
	
	private class NoCombinationFoundException extends Exception {

		public NoCombinationFoundException() {
			super();
		}


	}
}
