package bishe.frontentity;

/**
 * Created by sjh on 16/4/26.
 */
public class ReturnModel {
        private int totalNumber;

        private Object returnData;


        public ReturnModel(int totalNumber, Object returnData) {
            this.totalNumber = totalNumber;
            this.returnData = returnData;
        }

        public int getTotalNumber() {
            return totalNumber;
        }

        public void setTotalNumber(int totalNumber) {
            this.totalNumber = totalNumber;
        }

        public Object getReturnData() {
            return returnData;
        }

        public void setReturnData(Object returnData) {
            this.returnData = returnData;
        }
}
