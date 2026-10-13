import {Indexable} from './Indexable';

export interface Car extends Indexable   {
  referenceName : string;
  brand : string;
  inUse : boolean;
}


export type CarRequest={
  referenceName : string;
  brand : string;
}
